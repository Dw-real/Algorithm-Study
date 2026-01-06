import java.io.*;
import java.util.*;

class Main {
    static boolean valid = false;

    static void dfs(String t, String s) {
        if (t.length() == s.length()) {
            if (t.equals(s)) {
                valid = true;
            }
            return;
        }

        // A로 끝나는 경우 A를 제거
        if (t.endsWith("A")) {
            dfs(t.substring(0, t.length() - 1), s);
        }
        // B로 시작하는 경우 뒤집고 B 제거
        if (t.startsWith("B")) {
            dfs(new StringBuilder(t).reverse().substring(0, t.length() - 1), s);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();

        dfs(t, s);

        if (!valid)
            bw.write(0 + "\n");
        else
            bw.write(1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
