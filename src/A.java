import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class A {
    public static void main(String[] args) throws IOException {
        System.out.println("Preparando datagrama...");

        int port = 6780;
        InetAddress destino = InetAddress.getLocalHost();
        byte [] cadenaBytes = new byte[1024];
        String saludo = "Que pasa loco";
        cadenaBytes = saludo.getBytes();//relleno bytes con el mensaje saludo

        //create datagram packet to be sent
        DatagramPacket sendDatagram = new DatagramPacket(cadenaBytes,cadenaBytes.length, destino,port);

        //create Datagram socket to send the datagram package
        DatagramSocket socket = new DatagramSocket(6998);

        System.out.println("Enviando datagrama de longitud: " + sendDatagram.getLength());
        System.out.println("HOST de destino: " + destino.getHostName());
        System.out.println("IP de destino: " + destino.getHostAddress());
        System.out.println("Puerto local del socket " + socket.getLocalPort());
        System.out.println("Puerto al que envío " + sendDatagram.getPort());

        //send the message and close the socket
        socket.send(sendDatagram);
        socket.close();
    }
}