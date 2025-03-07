import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 동굴의 길이
        int h = Integer.parseInt(st.nextToken()); // 동굴의 높이

        int[] arr = new int[h];
        for (int i=0; i<n; i++) {
            int size = Integer.parseInt(br.readLine());

            if (i % 2 == 0) { // 석순
                arr[0] += 1;
                arr[size] -= 1;
            } else { // 종유석
                arr[h - size] += 1;
            }
        }

        int[] sum = new int[h];
        sum[0] = arr[0];

        int min = Integer.MAX_VALUE;

        for (int i=1; i<h; i++) {
            sum[i] = sum[i - 1] + arr[i];
            min = Math.min(min, sum[i]);
        }

        int count = 0;
        for (int i=0; i<h; i++) {
            if (min == sum[i])
                count++;
        }

        bw.write(min + " " + count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
