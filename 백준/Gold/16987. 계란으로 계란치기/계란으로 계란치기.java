import java.io.*;
import java.util.*;

class Main {
    static int max = 0;
    static int n;
    static int[][] egg;

    static void crash(int idx) {
        if (idx == n) { // 가장 오른쪽
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (egg[i][0] <= 0)
                    count++;
            }
            max = Math.max(max, count);
            return;
        }

        if (egg[idx][0] <= 0) { // 손에 들고 있는 계란이 깨졌다면
            crash(idx + 1);
        }

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (idx == i)
                continue;

            int hand = egg[idx][0];
            int tmp = egg[i][0];

            if (egg[idx][0] > 0 && egg[i][0] > 0) {
                flag = true;
                egg[idx][0] -= egg[i][1];
                egg[i][0] -= egg[idx][1];
                crash(idx + 1);
                egg[idx][0] = hand;
                egg[i][0] = tmp;
            }
        }

        if (!flag) { // 깨지지 않은 다른 계란이 없는 경우
            crash(idx + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine()); // 계란의 수
        egg = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()); // 내구도
            int w = Integer.parseInt(st.nextToken()); // 무게
            egg[i][0] = s;
            egg[i][1] = w;
        }

        crash(0);

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
