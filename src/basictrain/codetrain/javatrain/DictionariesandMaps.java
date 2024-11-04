package basictrain.codetrain.javatrain;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionariesandMaps {

    private static Map<String, Integer> phoneBook = new HashMap<>();

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            phoneBook.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            findPhone(s);
        }
        in.close();
    }

    static public void findPhone(String name){
        if(phoneBook.get(name) != null){
            System.out.println(name + "=" + phoneBook.get(name));
        }
        else {
            System.out.println("Not found");
        }
    }

}
