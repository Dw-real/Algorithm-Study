import java.io.*;
import java.util.*;


public class Main {
    static boolean groupWord(String word) {
        ArrayList<Character> arr = new ArrayList<Character>();

        arr.add(word.charAt(0));

        for (int i=1; i<word.length(); i++) {
            // 이전 문자와 다른 경우
            if (word.charAt(i) != word.charAt(i-1)) {
                if (arr.contains(word.charAt(i))) // 이미 나왔던 문자인 경우
                    return false;
                else
                    arr.add(word.charAt(i));
            }    
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i=0; i<n; i++) {
            String word = br.readLine();
            
            if (groupWord(word))
                count++;
        }

        bw.write(count + "" + "\n");
        
        br.close();
        bw.close();
    }
}
