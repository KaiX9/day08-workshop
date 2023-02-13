package sg.edu.nus.iss.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ProfileService {
    
    public String dirName = "day08data";
    public String fileName = "profile.txt";
    public String dirFileName = dirName + File.separator + fileName;

    public void readFile() throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File(dirFileName)));

        String line = "";
        Map<String, Integer> buffer = new HashMap<String, Integer>();
        // int occurence = 0;

        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter the word to search: ");
        // String scannerInput = scanner.nextLine();

        while((line = br.readLine()) != null) {
            line = line.replace(',', ' ');
            line = line.replace('.', ' ');
            String[] array = line.toLowerCase().split(" ");
            
                for (int x = 0; x < array.length; x++) {
                    String t = array[x].trim();
                    if (t.length() <= 0) {
                        continue;
                    }
                    Integer count = buffer.get(array[x]);
                    if (count == null) {
                        buffer.put(array[x], 1);
                    } else {
                        buffer.put(array[x], count + 1);
                        
                    }
                }

                for (Map.Entry mp: buffer.entrySet()) {
                    System.out.println(mp.getKey() + " " + mp.getValue());
                }

            
            // for(String s : buffer) {
            //     System.out.println("Word:" + s);
            //     if (s.equalsIgnoreCase(scannerInput)) {
            //         occurence++;
            //     }
            // }
        }

        // if (occurence == 0) {
        //     System.out.printf("Word \"%s\" is not found\n\n", scannerInput);
        // } else {
        //     System.out.printf("Word \"%s\" occurs %d number of times\n\n", scannerInput, occurence);
        // }

        br.close();
    }
}
