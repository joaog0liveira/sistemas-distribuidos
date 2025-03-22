package soquete.tcpthreads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int porta = 6789;

        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Servidor TCP aguardando conexões na porta " + porta + "...");

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new Cliente.ClienteHandler(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }
}
