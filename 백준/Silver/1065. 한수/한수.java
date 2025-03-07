import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i=1; i<=n; i++) {
            if (i < 100)
                count++;
            else {
                String str = String.valueOf(i);
                int diff = str.charAt(1) - str.charAt(0) - '0';
                boolean flag = true;
                for (int j=2; j<str.length(); j++) {
                    if (str.charAt(j) - str.charAt(j - 1) - '0' != diff) {
                        flag = false;
                        break;
                    }
                }
                if (flag) count++;
            }
        }

        bw.write(count + "\n");

        br.close();
        bw.close();
    }
}