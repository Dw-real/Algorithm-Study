import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;

    static void dfs(long a, long b, int count) {
        if (a == b) {
            min = Math.min(min, count);
            return;
        }
        if (a > b) {
            return;
        }

        dfs(a * 2, b, count + 1);
        dfs(a * 10 + 1, b, count + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        dfs(a, b, 1);

        if (min == Integer.MAX_VALUE)
            bw.write(-1 + "\n");
        else
            bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
