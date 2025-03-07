import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Path implements Comparable<Path> {
    int num1;
    int num2;
    double len;

    public Path(int num1, int num2, double len) {
        this.num1 = num1;
        this.num2 = num2;
        this.len = len;
    }

    @Override
    public int compareTo(Path p) {
        if (this.len > p.len)
            return 1;
        else
            return -1;
    }
}

public class Main {
    static int[] parent;
    static ArrayList<Point> location;
    static PriorityQueue<Path> path;

    static double getLength(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b)
            parent[a] = b;
        else
            parent[b] = a;
    }

    static int find(int a) {
        if (a == parent[a])
            return parent[a];
        else
            return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 우주신들의 개수
        int m = Integer.parseInt(st.nextToken()); // 이미 연결된 신들과의 통로의 개수

        parent = new int[n + 1];

        for (int i=1; i<=n; i++) {
            parent[i] = i;
        }

        location = new ArrayList<>();
        path = new PriorityQueue<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            location.add(new Point(x, y)); // 좌표 저장
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            union(n1, n2);
        }

        for (int i=0; i<location.size() - 1; i++) {
            for (int j=i + 1; j<location.size(); j++) {
                path.add(new Path(i + 1, j + 1, getLength(location.get(i), location.get(j))));
            }
        }

        int usePath = m;
        double length = 0;
        while (!path.isEmpty()) {
            Path now = path.poll();

            if (find(now.num1) != find(now.num2)) {
                length += now.len;
                union(now.num1, now.num2);
                usePath++;
            }
        }

        DecimalFormat df = new DecimalFormat(".00");
        String ans = df.format(length);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
