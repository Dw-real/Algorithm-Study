import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int minP1 = Integer.MAX_VALUE;
        int minP2 = Integer.MAX_VALUE;

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p1 = Integer.parseInt(st.nextToken()); // 6개 패키지 가격
            int p2 = Integer.parseInt(st.nextToken()); // 낱개 가격

            minP1 = Math.min(minP1, p1);
            minP2 = Math.min(minP2, p2);
        }

        int ans1 = minP1 * (n/6);

        if (n % 6 != 0) {
            if (minP1 > (n % 6)*minP2)
                ans1 += (n % 6)*minP2;
            else
                ans1 += minP1;
        }
        int ans2 = minP2 * n;

        bw.write(Math.min(ans1, ans2) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
