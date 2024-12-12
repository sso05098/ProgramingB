package chat.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class ChatServer {

	final String quitCommand = "quit";
	ServerSocket serverSocket;
	Map<String, ClientService> chatClientInfo = new Hashtable<>();
	
	public void start(int portNo) {
		
		try {
			serverSocket = new ServerSocket(portNo);
			System.out.println("[채팅서버] 시작 (" + InetAddress.getLocalHost() + ":" + portNo + ")");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 클라이언트 연결 요청을 받아서 채팅 서비스 제공 -> Daemon 처리 (connectclient)
	public void connectClient() {
		
		Thread thread = new Thread(() -> {
			try {
				
				while (true) {
					// 클라이언트 연결 요청에 대해 통신을 할 socket 생성
					Socket socket = serverSocket.accept();
					new ClientService(this, socket);
				}
				} catch (IOException e) {
					e.printStackTrace();
				}		
		});
		thread.setDaemon(true);
		thread.start();
		
	}
	
	public void stop() {
		
		try {
			serverSocket.close();
			System.out.println("[채팅서버] 종료");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addclientInfo(ClientService clientService) {
		chatClientInfo.put(clientService.displayName, clientService);
		System.out.println("[입장] " + clientService.displayName + "(채팅 참여자 수 : " + chatClientInfo.size() + ")");
	}
	
	public void sendToAll(ClientService clientservice, String message) {
		String timeStamp = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
		String timemessage = "[" + clientservice.displayName + "]" + "(" +timeStamp + "):" + message;
				
		// 해당 client가 보낸 메세지를 다른 채팅 참여자에게 전송
		for (ClientService cs : chatClientInfo.values()) {
			if ( cs != clientservice)
			cs.send(timemessage);
		}
	}
	
	public void removeClientInfo(ClientService clientService) {
		chatClientInfo.remove(clientService.displayName);
		System.out.println("[퇴장] " + clientService.displayName + "(채팅 참여자 수 : " + chatClientInfo.size() + ")");
	}
	
	public static void main(String[] args) {
		
		final int portNo = 50005;
		
		ChatServer chatServer = new ChatServer();
		
		// 채팅 서버 시작 (start)
		chatServer.start(portNo);
		
		// 클라이언트 연결 요청을 받아서 채팅 서비스 제공 -> Daemon 처리 (connectClient)
		chatServer.connectClient();
		
		// 종료 command 처리 (stop)
		while (true) {
		System.out.println("서버를 종료하려면 quit을 입력하고 Enter를 치세요.");
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		if (command.equalsIgnoreCase(chatServer.quitCommand)) break;
	}
	
	chatServer.stop();
	
	}
}
