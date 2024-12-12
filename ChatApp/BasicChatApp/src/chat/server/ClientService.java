package chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClientService {
	
	ChatServer chatServer;
	Socket socket;
	
	DataInputStream dis;
	DataOutputStream dos;
	
	String clientIP;
	String chatName;
	String displayName;
	
	final String quitCommand = "quit";
	
	public ClientService(ChatServer chatServer, Socket socket) throws IOException {
		
		// 필요 자료 구조 초기화
		this.chatServer = chatServer;
		this.socket = socket;
		
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		
		// 클라이언트 정보 수집 -> 서버한테 알려주기
		clientIP = socket.getInetAddress().getHostName();
		chatName = dis.readUTF();
		displayName = chatName + "@" + clientIP;
		
		chatServer.addclientInfo(this);
		
		// 입장 알림 -> ChatServer에게 요청
		chatServer.sendToAll(this, "[입장] ");
		
		// 클라이언트 보낸 메시지를 다른 채팅 참여자에게 전송 -> ChatServer에게 요청 -> thread(Daemon)
		
		receive();
	}
	
	public void receive() {
		
		new Thread(() -> {
			try {
				while (true) {
					String message = dis.readUTF();
					if (message.startsWith("/rename ")) {
						String newName = message.substring(8).trim();
						// 닉네임 중복 확인
						if (chatServer.chatClientInfo.containsKey(newName + "@" + clientIP)) {
							send("이미 사용 중인 닉네임입니다.");
						} else {
							// 기존 닉네임을 제거하고 새로운 닉네임을 추가
							chatServer.removeClientInfo(this);
							chatName = newName;
							displayName = chatName + "@" + clientIP;
							chatServer.addclientInfo(this);
							chatServer.sendToAll(this, "[닉네임 변경]" + displayName);
						}
						
					} else if (message.startsWith("/to ")) {
						String[] parts = message.split(" ", 3);
						if (parts.length == 3) {
							String recivename = parts[1];
							String msg = parts[2];
							ClientService fullname = chatServer.chatClientInfo.get(recivename + "@" + clientIP);
							if (fullname != null) {
								fullname.send("from " + displayName + ": " + msg);
							} else {
								send("사용자 [" + recivename + "]을 찾을수없어.");
							}
						}
					} else if (message.startsWith("/img ")) {
						String[] imgname = message.split(" ", 2);
						if (imgname.length == 2) {
							String filename = imgname[1];
							// 파일 크기 수신
							int fileSize = dis.readInt();
							byte[] fileByte = new byte[fileSize];
							dis.readFully(fileByte); // 파일 데이터 수신
							
							// 이미지 파일 저장
							Path filePath = Paths.get("C:\\Users\\User\\Pictures\\serverimg", filename);
							Files.write(filePath, fileByte); // 파일 저장
					        send("이미지가 저장되었습니다: " + filename);
						}
					}
					else {
						// 일반 메세지 처리
						System.out.println(displayName + "> " + message);
						if (message.equals(quitCommand)) break;
						chatServer.sendToAll(this, message);
				}
			}
				
			} catch(IOException e) {
				
			}
			
			quit();
		}).start();
			
	}
	
		public void send(String message) {
			
			try {
				dos.writeUTF(message);
				dos.flush();
			} catch (IOException e) {
			}
		}
	
		public void quit() {
			// 다른 참여 클라이언트들에게 퇴장 정보 전달
			chatServer.sendToAll(this, "[퇴장] " + displayName);
			// 서버에 저장된 클라이언트 정보 삭제
			chatServer.removeClientInfo(this);
			// 할당 받은 자원 close()
			close();
		}
		
		public void close() {
			try {
				dis.close();
				dos.close();
				socket.close();
			} catch (IOException e) {
				
			}
			
		}
}
