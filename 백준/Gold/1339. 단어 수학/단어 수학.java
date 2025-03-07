import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        Integer[] alphabet = new Integer[26]; // 알파벳에 대한 계수

        for (int i=0; i<alphabet.length; i++) {
            alphabet[i] = 0;
        }

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            int co = (int) Math.pow(10, str.length() -1);
            for (int j=0; j<str.length(); j++) {
                alphabet[str.charAt(j) - 'A'] += co;
                co /= 10;
            }
        }

        Arrays.sort(alphabet, (a, b) -> Integer.compare(b, a));

        int sum = 0;

        for (int i=9; i>=0; i--) {
            sum += (i * alphabet[9-i]);
        }

        bw.write(sum + "" + "\n");

        br.close();
        bw.close();
    }
}
