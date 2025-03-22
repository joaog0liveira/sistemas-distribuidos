package soquete.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String servidor = "localhost";
        int porta = 6789;

        try (Socket socket = new Socket(servidor, porta);
             PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Digite a região (ex: America/Sao_Paulo): ");
            String region = scanner.nextLine();

            saida.println(region);
            String response = entrada.readLine();
            System.out.println("Hora da região " + region + ": " + response);

        } catch (IOException e) {
            System.out.println("Erro na comunicação com o servidor: " + e.getMessage());
        }
    }
}
