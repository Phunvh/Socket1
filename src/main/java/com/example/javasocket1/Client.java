package com.example.javasocket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Nhập địa chỉ IP:");
            String serverAddress = consoleInput.readLine();
            System.out.println("Nhập port:");
            int port = Integer.parseInt(consoleInput.readLine());

            Socket socket = new Socket(serverAddress, port);
            System.out.println("Kết nối tới server thành công.");

            BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader clientIn = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter clientOut = new PrintWriter(socket.getOutputStream(), true);

            String serverMessage;
            while (true) {
                serverMessage = serverIn.readLine();
                if (serverMessage.equals("exit")) {
                    break;
                }
                System.out.println("Server: " + serverMessage);

                System.out.print("Client: "+ serverOut);
                String clientMessage = clientIn.readLine();
                clientOut.println(clientMessage);
            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
