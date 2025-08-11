import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;

    static int recursion(String s, int start, int end) {
        if (start >= end) return 1;
        else if (s.charAt(start) != s.charAt(end)) return 0;
        else {
            count++;
            return recursion(s, start + 1, end - 1);
        }
    }

    static int isPalindrome(String s) {
        count++;
        return recursion(s, 0, s.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            count = 0;
            String s = br.readLine();
            int ans = isPalindrome(s);

            bw.write(ans + " " + count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
