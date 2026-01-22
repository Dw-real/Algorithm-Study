import java.io.*;
import java.util.*;

class Main {
    static int[][] map;
    static int h, w;

    static int getRainwater(int x, int y) {
        int rainWater = 0;

        boolean flag = false;

        while (true) {
            y++;

            if (y == w) {
                break;
            }

            if (map[x][y] == 0) {
                rainWater++;
            }
            if (map[x][y] == 1) { // 다른 블록이 있는 경우 더 이상 빗물이 고일 수 없음
                flag = true;
                break;
            }
        }

        // 끝까지 이동했을 때 블록을 보지 못한 경우 빗물이 고일 수 없음
        if (!flag) {
            rainWater = 0;
        }

        return rainWater;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new int[h][w];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < w; i++) {
            int height = Integer.parseInt(st.nextToken());
            for (int j = h - 1; j >= h - height; j--) {
                map[j][i] = 1; // 블록
            }
        }

        int ans = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) {
                    ans += getRainwater(i, j);
                }
            }
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}