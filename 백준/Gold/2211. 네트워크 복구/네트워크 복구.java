import java.io.*;
import java.util.*;

class Line implements Comparable<Line> {
    int start;
    int end;
    int time;

    public Line(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }

    @Override
    public int compareTo(Line l) {
        return this.time - l.time;
    }
}

public class Main {
    static int n, m;
    static ArrayList<Line>[] graph;
    static boolean[] visited;
    static int[] time;
    static int INF = 100000;
    static ArrayList<Line> ans = new ArrayList<>();

    static void dijkstra() {
        PriorityQueue<Line> pq = new PriorityQueue<>();
        time[1] = 0;
        visited[1] = true;
        pq.add(new Line(1, 1, 0));

        while (!pq.isEmpty()) {
            Line line = pq.poll();
            int end = line.end;

            if (!visited[end]) {
                ans.add(line);
                visited[end] = true;
            }

            for (Line next : graph[end]) {
                if (!visited[next.end]) {
                    if (time[next.end] > time[end] + next.time) {
                        time[next.end] = time[end] + next.time;
                        pq.add(new Line(next.start, next.end, time[next.end]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        time = new int[n + 1];
        Arrays.fill(time, INF);

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Line(a, b, c));
            graph[b].add(new Line(b, a, c));
        }

        dijkstra();

        bw.write(ans.size() + "\n");

        for (Line line : ans) {
            bw.write(line.start + " " + line.end + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
