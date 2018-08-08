package Internet;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by taoLen on 8/7/2018.
 */
public class TaoServer2 {
    BartQuote bart = new BartQuote();

    public static void main(String[] args) {
        int port = 1234;
        String welcome = "Welcome to TaoServer 2.0";
        String listenToPort = "Listening to port " + port;
        String con = "Connection established";
        String exc = "System exception!";
        ServerSocket ss;
        Socket s;
        Thread t;
        try{
            System.out.println(welcome);
            System.out.println(listenToPort);
            ss = new ServerSocket(port);
            while (true){
                s = ss.accept();
                System.out.println(con);
                t = new Thread();
            }
        } catch (Exception e){
            System.out.println(exc);
        }
    }
    class TaoThread implements Runnable{
        private Socket s;
        private BartQuote bart;
        public TaoThread(Socket socket, BartQuote bartQuote){
            this.s=socket;
            this.bart = bartQuote;
        }
        @Override
        public void run() {
            String client = s.getInetAddress().toString();
            System.out.println("Connected to: " + client);
            try{
                Scanner in = new Scanner(s.getInputStream());
                PrintWriter out = new PrintWriter(s.getOutputStream(),true);
                out.println("Welcome to TaoServer 2.0");
                out.println("Enter BYE to exit.");
                while (true){
                    String input = in.nextLine();
                    if (input.equalsIgnoreCase("bye")){
                        break;
                    } else if (input.equalsIgnoreCase("get")){
                        out.println(bart.getQuote());
                        System.out.println("Serving " + client);
                    } else
                        out.println("Huh?");
                }
                out.println("So long suckers!");
                s.close();
            } catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Closed connection to " + client);
        }
    }
}
