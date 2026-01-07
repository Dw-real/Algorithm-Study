import java.io.*;
import java.util.*;

class Main {
    static int[] calendar = new int[367];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 일정의 개수
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()); // 일정의 시작날짜
            int e = Integer.parseInt(st.nextToken()); // 일정의 종료날짜

            for (int j = s; j <= e; j++) {
                calendar[j]++;
            }
        }

        int area = 0;
        int width = 0;
        int maxHeight = 0;

        for (int i = 1; i <= 366; i++) {
            if (calendar[i] == 0) {
                area += width * maxHeight;
                width = 0;
                maxHeight = 0;
                continue;
            }

            width++;
            maxHeight = Math.max(maxHeight, calendar[i]);
        }

        bw.write(area + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
