import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] board;

    static int paint(int x, int y, boolean color) {
        int count = 0;
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[x + i][y + j] == color)
                        count++;
                }
                else
                    if (board[x + i][y + j] != color)
                        count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new boolean[n][m];
        int ans = 32; // 8 * 8에서 다시 칠해야하는 정사각형의 최댓값

        // board 초기화
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                char c = str.charAt(j);

                if (c == 'W')
                    board[i][j] = true;
            }
        }

        for (int i=0; i<n - 7; i++) {
            for (int j=0; j<m - 7; j++) {
                ans = Math.min(ans, Math.min(paint(i, j, false), paint(i, j, true)));
            }
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}