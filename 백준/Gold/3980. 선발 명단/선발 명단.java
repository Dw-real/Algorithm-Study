import java.io.*;
import java.util.*;


public class Main {
    static int[][] overall;
    static boolean[] visited;
    static int max = 0;

    static void selectPlayer(int sum, int depth) {
        if (depth == 11) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if (!visited[i] && overall[depth][i] != 0) {
                visited[i] = true;
                selectPlayer(sum + overall[depth][i], depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for (int i = 0; i < c; i++) {
            overall = new int[11][11];
            visited = new boolean[11];
            max = 0;
            for (int j = 0; j < 11; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < 11; k++) {
                    overall[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            selectPlayer(0, 0);
            bw.write(max + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
