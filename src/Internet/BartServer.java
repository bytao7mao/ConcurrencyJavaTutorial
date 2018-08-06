package Internet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by taoLen on 8/6/2018.
 */
public class BartServer {
    public static void main(String[] args) throws IOException {
        int port =1234;
        BartQuote bartQuote = new BartQuote();
        try {
            System.out.println("BartServer 1.0");
            System.out.println("Listening to port " + port);
            //using Server socket to estabilish connection on port 1234
            ServerSocket serverSocket=new ServerSocket(port);
            //when connection is accepter assign to socket var
            Socket socket= serverSocket.accept();
            //getting ip from connection as string
            String client = socket.getInetAddress().toString();
            System.out.println("Connected to " + client);

            //using a scanner to READ data from the client
            Scanner in = new Scanner(socket.getInputStream());
            //SEND data to a client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //sending this message to the client
            out.println("Welcome to BartServer 1.0");
            out.println("Enter GET to get a quaote " +
             "or BYE to exit");
            while(true){
                String input = in.nextLine();
                if (input.equalsIgnoreCase("bye"))
                    break;
                else if (input.equalsIgnoreCase("get")){
                    out.println(bartQuote.getQuote());
                    System.out.println("Serving " + client);
                } else {
                    System.out.println("Huh?");
                }
            }
            out.println("So long suckers!");
            socket.close();
            System.out.println("Close connection to " + client);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
