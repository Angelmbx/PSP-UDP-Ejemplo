import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class B {

    public static void main(String[] args) throws IOException {

        System.out.println("Esperando datagrama...");

        byte[] bufer = new byte[1024];
        //create datagram packet to recieve the message
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);

        //create Datagram socket to recieve the message
        DatagramSocket socket = new DatagramSocket(6780, InetAddress.getByName("localhost"));
        //socket accepts the message
        socket.receive(recibo);

        System.out.println("Datagrama recibido");

        //show message info
        int bytesNumber = recibo.getLength();
        String mensaje = new String(recibo.getData());//transforms the message's bytes to a String
        System.out.println("Numero de bytes recibidos: "+ bytesNumber);
        System.out.println("Message: " + mensaje.trim());
        System.out.println("REMOTE PORT: " + recibo.getPort());
        System.out.println("REMOTE IP: " + recibo.getAddress().getHostAddress());
        System.out.println("Puerto destino: " + socket.getLocalPort());

        //close socket
        socket.close();
    }


}
