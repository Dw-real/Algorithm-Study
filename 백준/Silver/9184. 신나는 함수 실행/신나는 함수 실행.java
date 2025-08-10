import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long[][][] cache;

    static long w(int a, int b, int c) {
        if (isPossible(a, b, c) && cache[a][b][c] != 0)
            return cache[a][b][c];

        if (a <= 0 || b <= 0 || c <= 0)
            return 1;

        if (a > 20 || b > 20 || c > 20)
            return w(20, 20, 20);

        if (a < b && b < c)
            return cache[a][b][c] = w(a, b, c-1) + w (a, b - 1, c- 1) - w(a, b - 1, c);

        return cache[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    static boolean isPossible(int a, int b, int c) {
        return a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20;
    }

    static String getAnswer(int a, int b, int c) {
        return "w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        cache = new long[21][21][21];
        cache[0][0][0] = 1;

        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1)
                break;

            sb.append(getAnswer(a, b, c));
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
