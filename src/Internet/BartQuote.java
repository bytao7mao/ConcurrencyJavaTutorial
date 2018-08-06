package Internet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by taoLen on 8/6/2018.
 */
public class BartQuote {
    static Scanner scanner = new Scanner(System.in);
    ArrayList<String> arrayList = new ArrayList<>();
    BartQuote(){
        arrayList.add("I will not waste chalk");
        arrayList.add("I will not skateboard in the halls");
        arrayList.add("I will not burp in the class");
    }
    public String getQuote(){
        int i = (int) (Math.random()*arrayList.size());
        return arrayList.get(i);
    }

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\taoLen\\Desktop\\ConcurrencyThreadSynchronization\\src\\quotes.txt";
        File file = new File(path);
        //first method to read
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//        String string;
//        while ((string = bufferedReader.readLine()) != null)
//            System.out.println(string);

        //second method to read
        scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }

}
