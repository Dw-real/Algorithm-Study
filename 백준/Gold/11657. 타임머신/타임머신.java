import java.io.*;
import java.util.*;

class Bus implements Comparable<Bus> {
    int start;
    int end;
    int time;

    public Bus(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }

    @Override
    public int compareTo(Bus e) {
        return this.time - e.time;
    }
}

public class Main {
    static int n, m;
    static Bus[] bus;
    static long[] distance;
    static boolean isCycle;

    static void bellman_ford(int start) {
        distance[start] = 0;
        for (int i=1; i<n; i++) {
            for (int j=0; j<m; j++) {
                Bus b = bus[j];
                // 최단 거리가 있을 때 업데이트
                if (distance[b.start] != Integer.MAX_VALUE && distance[b.end] > distance[b.start] + b.time) {
                    distance[b.end] = distance[b.start] + b.time;
                }
            }
        }
        isCycle = false;

        for (int i=0; i<m; i++) { // 음수 사이클 확인
            Bus b = bus[i];
            if (distance[b.start] != Integer.MAX_VALUE && distance[b.end] > distance[b.start] + b.time)
                isCycle = true;    
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 도시의 개수
        m = Integer.parseInt(st.nextToken()); // 버스 노선의 개수

        distance = new long[n + 1];
        for (int i=1; i<=n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        bus = new Bus[m];
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            bus[i] = new Bus(s, e, t);
        }

        bellman_ford(1);
        if (!isCycle) {
            for (int i=2; i<=n; i++) {
                if (distance[i] == Integer.MAX_VALUE)
                    bw.write(-1 + "\n");
                else
                    bw.write(distance[i] + "\n");
            }
        }
        else
            bw.write(-1 + "\n");
            
        bw.flush();
        bw.close();
        br.close();
    }
}
