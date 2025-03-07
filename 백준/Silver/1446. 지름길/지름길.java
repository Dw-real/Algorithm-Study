import java.io.*;
import java.util.*;

class Shortcut implements Comparable<Shortcut> {
    int e;
    int l;

    public Shortcut(int e, int l) {
        this.e = e;
        this.l = l;
    }

    @Override
    public int compareTo(Shortcut s) {
        return this.l - s.l;
    }
}

public class Main {
    static int[] dist;
    static ArrayList<Shortcut>[] list;
    static int n, d;

    static void dijkstra() {
        PriorityQueue<Shortcut> pq = new PriorityQueue<>();
        dist[0] = 0;
        pq.add(new Shortcut(0, 0));

        while (!pq.isEmpty()) {
            Shortcut now = pq.poll();

            if (now.e + 1 <= d && now.l + 1 < dist[now.e + 1]) {
                dist[now.e + 1] = now.l + 1;
                pq.add(new Shortcut(now.e + 1, dist[now.e] + 1));
            }

            for (Shortcut next : list[now.e]) {
                if (dist[next.e] > dist[now.e] + next.l) {
                    dist[next.e] = dist[now.e] + next.l;
                    pq.add(new Shortcut(next.e, dist[next.e]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 지름길의 개수
        d = Integer.parseInt(st.nextToken()); // 고속도로의 길

        dist = new int[d + 1];
        list = new ArrayList[d + 1];
        for (int i=0; i<=d; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()); // 시작 위치
            int e = Integer.parseInt(st.nextToken()); // 도착 위치
            int l = Integer.parseInt(st.nextToken()); // 길이

            if (e <= d)
                list[s].add(new Shortcut(e, l));
        }

        dijkstra();

        bw.write(dist[d] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
