package Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by taoLen on 8/6/2018.
 */
public class HostLookup {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the IP lookup application.");
        String host;
        do{
            System.out.println("\nEnter a host name: ");
            host = scanner.nextLine();
            try {
                //performs a DNS lookup on the host name
                //and returns an array that contains
                //all the internet addresses for the name
                InetAddress[] addresses
                        = InetAddress.getAllByName(host);
                for (InetAddress ip:addresses){
                    System.out.println(ip.toString());
                }
            }catch (UnknownHostException e){
                System.out.println("Unknown host.");
            }
        }while (doAgain());
    }
    private static boolean doAgain(){
        System.out.println();
        String s;
        while (true){
            System.out.println("Look up for another ?? " + "(Y or N)");
            s = scanner.nextLine();
            return s.equalsIgnoreCase("y");
        }
    }
}
