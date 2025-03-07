import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String doc = br.readLine();
        String word = br.readLine();

        int count = 0;
        int startIndex = 0;
        int endIndex = doc.length() - 1;

        while (true) {
            if (endIndex - startIndex + 1 < word.length())
                break;

            String tmp = doc.substring(startIndex, startIndex + word.length());

            if (tmp.equals(word)) {
                count++;
                startIndex += word.length();
            }
            else
                startIndex++;
        }
        
        if (doc.equals(word))
            bw.write(1 + "\n");
        else
            bw.write(count + "" + "\n");

        br.close();
        bw.close();
    }
}
