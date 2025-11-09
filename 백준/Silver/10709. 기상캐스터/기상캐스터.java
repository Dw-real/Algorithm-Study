import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] board = new char[h + 1][w + 1];
        int[][] ans = new int[h + 1][w + 1];

        ArrayList<int[]> clouds = new ArrayList<>();

        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            for (int j = 0; j < w; j++) {
                board[i + 1][j + 1] = str.charAt(j);
                if (board[i + 1][j + 1] == '.')
                    ans[i + 1][j + 1] = -1;
                if (board[i + 1][j + 1] == 'c')
                    clouds.add(new int[]{i + 1, j + 1});
            }
        }

        for (int[] cloud : clouds) {
            int x = cloud[0];
            int y = cloud[1] + 1;
            while (y <= w && board[x][y] == '.') {
                ans[x][y] = ans[x][y - 1] + 1;
                y++;
            }
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                bw.write(ans[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
