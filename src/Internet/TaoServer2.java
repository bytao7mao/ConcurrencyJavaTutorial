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
    static int port = 0770;
    static String welcome = "Welcome to TaoServer 2.0";
    static String listenToPort = "Listening to port " + port;
    static String con = "Connection established";
    static String exc = "System exception!";
    static ServerSocket ss;
    static Socket s;
    static Thread t;
    public static void main(String[] args) {
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
        TaoServer2 taoServer2 = new TaoServer2();
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
                out.println(welcome);
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
