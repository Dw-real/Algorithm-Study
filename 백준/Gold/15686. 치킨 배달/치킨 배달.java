import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance(Point p) {
        return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
    }
}

public class Main {
    static int[][] map;
    static ArrayList<Point> chicken;
    static ArrayList<Point> home;
    static ArrayList<Point> c; // 폐업 시키지 않을 치킨 집
    static int n, m;
    static int min = Integer.MAX_VALUE;

    static void choose(int start, int depth) {
        if (depth == m) {
            getAns();
            return;
        }
        for (int i=start; i<chicken.size(); i++) {
            c.add(chicken.get(i));
            choose(i + 1, depth + 1);
            c.remove(c.size() -1);
        }
    }

    static void getAns() {
        int sum = 0;
        for (int i=0; i<home.size(); i++) {
            int minD = Integer.MAX_VALUE;
            for (int j=0; j<c.size(); j++) {
                int dist = home.get(i).getDistance(c.get(j));
                minD = Math.min(minD, dist);
            }
            sum += minD;
        }
        min = Math.min(min, sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        c = new ArrayList<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    home.add(new Point(i, j));
                else if (map[i][j] == 2)
                    chicken.add(new Point(i, j));
            }
        }

        choose(0, 0);

        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}