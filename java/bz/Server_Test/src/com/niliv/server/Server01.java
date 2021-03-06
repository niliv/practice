package com.niliv.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Server01 {
	
	private ServerSocket serverSocket;
	private boolean isRunning;
	public static void main(String[] args) throws IOException {
		Server01 server = new Server01();
		server.start();
	}
	
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			isRunning=true;
			receive();
		} catch (IOException e) {
			stop();
			e.printStackTrace();
		}
		
	}
	
	public void receive() throws IOException {
		
		while(isRunning) {
			Socket client= serverSocket.accept();
			System.out.println("一个客户端建立连接");
			
			new Thread(new Dispatcher(client)).start();
		}
		
		
	}
	
	public void stop() {
		isRunning=false;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}

