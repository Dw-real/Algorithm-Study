import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();
        int idx = 0;
        int ans = 1;

        while (idx < num.length()) {
            String s = String.valueOf(ans);

            if (s.indexOf(num.charAt(idx)) == -1) {
                ans++;
                continue;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == num.charAt(idx)) {
                    idx++;
                    if (idx == num.length())
                        break;
                }
            }
            ans++;
        }

        bw.write(ans - 1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
