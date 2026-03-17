import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();

        char[] c = n.toCharArray();
        Arrays.sort(c);

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = c.length - 1; i >= 0; i--) {
            sum += c[i] - '0';
            sb.append(c[i] - '0');
        }

        if (sum % 3 == 0 && c[0] - '0' == 0) {
            bw.write(sb + "\n");
        } else {
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}