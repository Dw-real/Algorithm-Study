import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int h,w;

    static int countRain(int x, int y) {
        int count = 0;
        for (int i=y+1; i<w; i++) {
            if (map[x][i] == 0)
                count++;
            else if (map[x][i] == 1)
                break;
        }
        if (map[x][w - 1] == 0 && count == w - y - 1) { // 행의 끝까지 블록을 보지 못하면 비가 고이지 않음
            count = 0;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new int[h][w];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<w; i++) {
            int height = Integer.parseInt(st.nextToken()); // 블록이 쌓인 높이
            for (int j=h-height; j<h; j++) {
                map[j][i] = 1;
            }
        }

        int sum = 0;
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (map[i][j] == 1) {
                    sum += countRain(i, j);
                }
            }
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
