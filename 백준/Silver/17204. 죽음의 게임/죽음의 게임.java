import java.io.*;
import java.util.*;

public class Main {
    static int[] point;

    static int bfs(int n, int k) {
        int result = -1;
        int now = 0;
        int count = 0;
        boolean[] visited = new boolean[n];

        while (true) {
            count++;
            int next = point[now];
            if (next == k) {
                result = count;
                break;
            }
            if (!visited[next]) {
                visited[next] = true;
                now = next;
            }
            else {
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 참가자 수
        int k = Integer.parseInt(st.nextToken()); // 보성이의 번호

        point = new int[n];
        for (int i=0; i<n; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }

        bw.write(bfs(n, k) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
