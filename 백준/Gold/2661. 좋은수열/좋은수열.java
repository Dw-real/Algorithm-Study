import java.io.*;
import java.util.*;

class Main {
    static int n;

    static void dfs(StringBuilder sb, int length) {
        if (n == length) {
            System.out.println(sb.toString());
            System.exit(0);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            sb.append(i);
            if (valid(sb))
                dfs(sb, length + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static boolean valid(StringBuilder sb) {
        for (int i = 1; i <= sb.length() / 2; i++) {
            String front = sb.substring(sb.length() - i * 2, sb.length() - i);
            String back = sb.substring(sb.length() - i, sb.length());
            if (front.equals(back))
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(1);

        dfs(sb, 1);

        br.close();
    }
}