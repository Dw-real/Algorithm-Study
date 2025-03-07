import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] temp = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0; i<k; i++) {
            sum += temp[i];
        }

        max = Math.max(sum, max);

        for (int i=k; i<n; i++) {
            int j = i - k;
            sum += temp[i];
            sum -= temp[j];
            max = Math.max(sum, max);
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
