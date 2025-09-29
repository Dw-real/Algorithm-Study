import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer[] alphabet = new Integer[26];

        Arrays.fill(alphabet, 0);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int co = (int) Math.pow(10, str.length() - 1);

            for (int j = 0; j < str.length(); j++) {
                alphabet[str.charAt(j) - 'A'] += co;
                co /= 10;
            }
        }

        Arrays.sort(alphabet, Collections.reverseOrder());

        int sum = 0;

        for (int i = 9; i >= 0; i--) {
            sum += (i * alphabet[9 - i]);
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
