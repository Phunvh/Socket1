package com.example.javasocket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Nhập port:");
            int port = Integer.parseInt(consoleInput.readLine());

            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server đang chạy...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client đã kết nối.");

            BufferedReader clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter clientOut = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader serverIn = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter serverOut = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;
            while (true) {
                clientMessage = clientIn.readLine();
                if (clientMessage.equals("exit")) {
                    break;
                }
                System.out.println("Client: " + clientMessage);

                System.out.print("Server: "+ serverOut);
                String serverMessage = serverIn.readLine();
                clientOut.println(serverMessage);
            }

            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}