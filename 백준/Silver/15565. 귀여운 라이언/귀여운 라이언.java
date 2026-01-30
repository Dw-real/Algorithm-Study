import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 인형의 개수
        int k = Integer.parseInt(st.nextToken()); // 포함되어야하는 라이언 인형 수

        int[] dolls = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;

        int ryan = 0;

        if (dolls[0] == 1) {
            ryan++;
        }

        int length = Integer.MAX_VALUE;

        while (end < n - 1) {
            end++;
            if (dolls[end] == 1) ryan++;

            while (ryan >= k) {
                length = Math.min(length, end - start + 1);
                if (dolls[start] == 1) ryan--;
                start++;
            }
        }

        if (length != Integer.MAX_VALUE) {
            bw.write(length + "\n");
        } else {
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}