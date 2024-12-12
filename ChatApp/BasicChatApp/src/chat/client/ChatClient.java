package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ChatClient {
	
	String chatName;
	Socket socket;
	
	DataInputStream dis;
	DataOutputStream dos;
	
	final String quitCommand = "quit";
	
	public void connect(String serverIP, int portNo, String chatName) {
		
		try {
			// 서버에 연결
			socket = new Socket(serverIP, portNo);

			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			// 대화명 저장하고 서버에 대화명을 알려줌
			this.chatName = chatName;
			send(chatName);
			
			System.out.println("[" + chatName + "] 채팅 서버 연결 성공 (" + serverIP + ":" + portNo + ")");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String message) {
		try {
			// 닉네임 변경 명령어
			if (message.startsWith("/rename ")) {
				String newName = message.substring(8).trim();
				// 새로운 닉네임이 비어있지 않다면 서버에 전송
				if (!newName.isEmpty()) {
					dos.writeUTF("/rename " + newName);
					dos.flush();
				} else {
					System.out.println("닉네임은 비어있을 수 없습니다.");
				}
			}
			
			// 멘션 명령어 처리
			else if (message.startsWith("/to ")) {
				String[] parts = message.split(" ", 3);
				if ( parts.length == 3) {
					String recivename = parts[1]; // 받는 사람 이름
					String msg = parts[2]; // 보낼 메세지
					dos.writeUTF("/to " + recivename + " " + msg);
					dos.flush();
				} else {
				System.out.println("사용법 : /to 닉네임 메세지");
				}
			}
			else if (message.startsWith("/img ")) {
				String imgname = message.substring(5).trim(); // 파일명 추출
				Path imgpath = Paths.get("C:\\Users\\User\\Pictures\\img", imgname); // 파일 경로 설정
				
				// 파일 유무 확인
				if (Files.exists(imgpath)) {
					dos.writeUTF("/img " + imgname); // 파일 전송 요청
					// 파일 내용을 전송
					byte[] fileBytes = Files.readAllBytes(imgpath);
					dos.writeInt(fileBytes.length); // 파일 크기 전송
					dos.write(fileBytes); // 파일 데이터 전송
					dos.flush();
				} else {
					System.out.println("파일이 존재하지 않습니다.");
				}
			}
			else { // 일반 메세지 처리
			dos.writeUTF(message);
			dos.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void receive() {
		new Thread(() -> {
			try {
				while (true) {
					String message = dis.readUTF();
					System.out.println(message);
					System.out.println("> ");
				}
			} catch (IOException e) {
				// 서버가 종료된 경우, dis가 close된 경우
				quit();
				System.exit(0);
			}
		}).start();
	}
	public void quit() {
		
		try {
			dis.close();
			dos.close();
			socket.close();
			System.out.println("[" + chatName + "] 채팅 서버 연결 종료");
		} catch (IOException e) {
			
		}
	}
	
	public static void main(String[] args) {
		
		final String serverIP = "localhost";
		final int portNo = 50005;
		
		ChatClient chatClient = new ChatClient();
		
		// 대화명 입력을 받아서 서버 연결 시 전달
		System.out.print("대화명을 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		String chatName = sc.nextLine();
		
		// 서버 연결 (connect)
		chatClient.connect(serverIP, portNo, chatName);
		
		// 채팅 서버로부터 메시지를 받아서 처리 -> thread 처리 (receive)
		chatClient.receive();
		
		// 사용자가 입력한 메시지를 서버로 전송 (send)
		while (true) {
			System.out.println("> ");
			String message = sc.nextLine();
			chatClient.send(message);
			if (message.equals(chatClient.quitCommand)) break;
		}
		
		// 사용자가 입력한 메시지에 quit command가 있으면 퇴장 처리 (quit)
		chatClient.quit();
		
	}
}
