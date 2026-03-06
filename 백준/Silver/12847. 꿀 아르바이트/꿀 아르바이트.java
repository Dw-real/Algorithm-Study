import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 월세를 내기 바로 전 날까지 기간
        int m = Integer.parseInt(st.nextToken()); // 일을 할 수 있는 날

        long[] pay = new long[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            pay[i] = Long.parseLong(st.nextToken());
        }

        long max = 0;
        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += pay[i];
        }

        max = Math.max(max, sum);

        for (int i = m; i < n; i++) {
            sum += pay[i];
            sum -= pay[i - m];
            max = Math.max(max, sum);
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}