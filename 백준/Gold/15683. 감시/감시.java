import java.io.*;
import java.util.*;

class CCTV {
    int r;
    int c;
    int num; // cctv 번호

    public CCTV(int r, int c, int num) {
        this.r = r;
        this.c = c;
        this.num = num;
    }
}

public class Main {
    static int n, m;
    static int[][] office;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dir = {
            {}, // dummy
            {0},
            {0, 2},
            {0, 3},
            {0, 2, 3},
            {0, 1, 2, 3}
    };

    static ArrayList<CCTV> cctv = new ArrayList<>();
    static int min = 100;

    static void dfs(int count, int[][] office) {
        if (count == cctv.size()) {
            min = Math.min(min, getCount(office));
            return;
        }

        int r = cctv.get(count).r;
        int c = cctv.get(count).c;
        int num = cctv.get(count).num;

        for (int i=0; i<4; i++) {
            int[][] copyOffice = getCopyOffice(office);

            for (int move : dir[num]) {
                int nd = (move + i) % 4;
                int nr = r;
                int nc = c;

                while (true) {
                    nr += dx[nd];
                    nc += dy[nd];

                    if (!isValid(nr, nc))
                        break;

                    copyOffice[nr][nc] = -1; // 감시한 곳은 -1로
                }
            }

            dfs(count + 1, copyOffice);
        }
    }

    static int[][] getCopyOffice(int[][] office) {
        int[][] copyOffice = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                copyOffice[i][j] = office[i][j];
            }
        }
        return copyOffice;
    }

    static int getCount(int[][] office) {
        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (office[i][j] == 0)
                    count++;
            }
        }

        return count;
    }

    static boolean isValid(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m)
            return false;
        if (office[x][y] == 6) // 벽
            return false;

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        office = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++){
                office[i][j] = Integer.parseInt(st.nextToken());

                if (office[i][j] >= 1 && office[i][j] <= 5)
                    cctv.add(new CCTV(i, j, office[i][j]));
            }
        }

        dfs(0, office);
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
