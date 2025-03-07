import java.io.*;
import java.util.*;

public class Main {
    static boolean isSquare(int[][] rect, int x, int y, int len) {
        return rect[x][y] == rect[x + len][y] && rect[x][y] == rect[x][y + len] && rect[x][y] == rect[x + len][y + len];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] rect = new int[n][m];

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                rect[i][j] = str.charAt(j) - '0';
            }
        }

        int ans = 1;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int len = 0;
                while (true) {
                    if (i + len >= n || j + len >= m)
                        break;

                    if (isSquare(rect, i, j, len))
                        ans = Math.max(ans, (len + 1) * (len + 1));

                    len++;
                }
            }
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
