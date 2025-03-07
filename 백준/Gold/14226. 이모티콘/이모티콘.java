import java.io.*;
import java.util.*;

public class Main {
    static int minTime = Integer.MAX_VALUE;
    static boolean[][] visited = new boolean[1001][1001];
    static int s;

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0, 0});
        visited[1][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int emo = now[0];
            int time = now[1];
            int clipboard = now[2];

            if (emo == s) {
                minTime = Math.min(minTime, time);
                continue;
            }

            // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if (emo != clipboard && clipboard <= 1000) {
                q.add(new int[]{emo, time + 1, emo});
            }
            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (clipboard + emo <= 1000 && !visited[clipboard + emo][clipboard]){
                q.add(new int[]{emo + clipboard, time + 1, clipboard});
                visited[clipboard + emo][clipboard] = true;
            }
            // 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (emo - 1 >= 0 && !visited[emo - 1][clipboard]) {
                q.add(new int[]{emo - 1, time + 1, clipboard});
                visited[emo - 1][clipboard] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = Integer.parseInt(br.readLine());

        bfs();

        bw.write(minTime + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
