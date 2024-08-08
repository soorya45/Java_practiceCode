import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
public class bb {
    static ServerSocket Serversocket;
    static DataInputStream dis;
    static DataOutputStream dos;
    public static void main(String[] args) throws SocketException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the size of the array:");
            int size = scanner.nextInt();
            int[] a = new int[size];
            System.out.println("Enter " + size + " integers separated by space:");
            for (int i = 0; i < size; i++) {
                a[i] = scanner.nextInt();
            }
            Serversocket = new ServerSocket(8011);
            System.out.println("waiting for connection");
            Socket client = Serversocket.accept();
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
            System.out.println("The number of packets sent is:" + a.length);
            int y = a.length;
            dos.write(y);
            dos.flush();
            for (int i = 0; i < a.length; i++) {
                dos.write(a[i]);
                dos.flush();
            }
            int k = dis.read();
            dos.write(a[k]);
            dos.flush();
        }
        catch (IOException e){
            System.out.println(e);
        }
        finally{
            try{
                dis.close();
                dos.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}