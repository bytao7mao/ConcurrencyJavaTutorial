package Internet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by taoLen on 8/6/2018.
 */
public class BartClient {
    public static void main(String[] args) {
        int port = 1234;
        System.out.println("Welcome to the Bart Client\n");
        Socket s = getSocket(port);
        try{
            System.out.println("connected to port " + port);
            //read - get data
            Scanner in = new Scanner(s.getInputStream());
            //write - send data
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            //discard the welcome msg
            in.nextLine();
            //discard the conn msg
            in.nextLine();
            //write quote and save it to quote String
            out.println("get");
            //after reading is finished we close the server
            out.println("bye");
            s.close();
            System.out.println("Connection closed!");

            String quote = in.nextLine();
            //write quotes till reaches 20 quotes
            for (int i=0; i<20;i++){
                System.out.println(quote);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static Socket getSocket(int port){
        Socket s;
        String host;
        InetAddress ip;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("What server do you want to connect to ? ");
            host=sc.nextLine();
            try{
                ip=InetAddress.getByName(host);
                s=new Socket(ip,port);
                return s;
            }catch (UnknownHostException e){
                System.out.println("The host is unknown.");
            }catch (IOException e){
                System.out.println("Network error.");
            }
        }
    }
}
