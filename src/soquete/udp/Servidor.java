package soquete.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Servidor {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9876);
        byte[] buffer = new byte[1024];

        System.out.println("Servidor aguardando solicitações...");

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String region = new String(packet.getData(), 0, packet.getLength()).trim();

            String response;
            try {
                response = ZonedDateTime.now(ZoneId.of(region)).toString();
            } catch (Exception e) {
                response = "Região inválida!";
            }

            byte[] responseData = response.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(
                    responseData, responseData.length, packet.getAddress(), packet.getPort()
            );
            socket.send(responsePacket);
        }
    }
}
