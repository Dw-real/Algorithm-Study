import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] lab;
    static int[][] copyLab; // 복사본
    static ArrayList<int[]> virus;
    static int max = 0;
    static int n;
    static int m;

    // 벽을 세울 3칸 정하기
    static void combination(int depth) {
        if (depth == 3) {
            copy();
            spreadVirus();
            return;
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    combination(depth + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    static void copy() {
        copyLab = new int[n][m];
        
        for (int i=0; i<copyLab.length; i++) {
            System.arraycopy(lab[i], 0, copyLab[i], 0, lab[0].length);
        }
    }

    static void spreadVirus() {
        Deque<int[]> dq = new ArrayDeque<int[]>();
        for (int i=0; i<virus.size(); i++) {
            dq.add(virus.get(i));
        }

        while (!dq.isEmpty()) {
            int[] coord = dq.poll();
        
            for (int i=0; i<4; i++) {
                int nx = coord[0] + dx[i];
                int ny = coord[1] + dy[i];

                if (isValidCoord(nx, ny) && copyLab[nx][ny] == 0) {
                    copyLab[nx][ny] = 2;
                    dq.add(new int[]{nx, ny});
                }
            }
        }

        countSafetyZone();
    }

    static void countSafetyZone() {
        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (copyLab[i][j] == 0)
                    count++;
            }   
        }
        max = Math.max(max, count);
    }

    static boolean isValidCoord(int x, int y) {
        return ((0 <= x && x < n) && (0 <= y && y < m)); 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        virus = new ArrayList<int[]>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][m];
        
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j=0; j<m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if (lab[i][j] == 2)
                    virus.add(new int[]{i, j});
            }
        }
        
        combination(0);

        bw.write(max + "" + "\n");

        br.close();
        bw.close();
    }
}
