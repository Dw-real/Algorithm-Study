import java.io.*;
import java.util.*;

class Virus implements Comparable<Virus> {
    int end;
    int time;

    public Virus(int end, int time) {
        this.end = end;
        this.time = time;
    }

    @Override
    public int compareTo(Virus c) {
        return this.time - c. time;
    }
}

public class Main {
    static ArrayList<Virus>[] graph;
    static boolean[] visited;
    static int[] times;
    static int INF = 10000001;

    static void dijkstra(int start) {
        PriorityQueue<Virus> pq = new PriorityQueue<>();
        Arrays.fill(times, INF);
        times[start] = 0;
        pq.add(new Virus(start, 0));

        while (!pq.isEmpty()) {
            Virus v = pq.poll();
            int com = v.end;

            if (visited[com]) continue;
            visited[com] = true;

            for (Virus next : graph[com]) {
                if (!visited[next.end]) {
                    if (times[next.end] > times[com] + next.time) {
                        times[next.end] = times[com] + next.time;
                        pq.add(new Virus(next.end, times[next.end]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수
        for (int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 수
            int d = Integer.parseInt(st.nextToken()); // 의존성 수
            int c = Integer.parseInt(st.nextToken()); // 해킹 당한 컴퓨터의 번호

            graph = new ArrayList[n + 1];
            for (int j=0; j<=n; j++) {
                graph[j] = new ArrayList<>();
            }
            visited = new boolean[n + 1];
            times = new int[n + 1];

            for (int j=0; j<d; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph[b].add(new Virus(a, s));
            }
            dijkstra(c);

            int count = 0;
            int max = 0;
            for (int j=1; j<=n; j++) {
                if (times[j] != INF) {
                    if (times[j] > max)
                        max = times[j];
                    count++;
                }

            }
            bw.write(count + " " + max + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
