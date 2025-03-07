import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int s;
    int e;
    int v;

    public Edge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(Edge e) {
        return this.v - e.v;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 ,1};
    static int n, m;
    static int[][] map;
    static int snum = 1;
    static boolean[][] visited;
    static ArrayList<ArrayList<int[]>> landList;
    static ArrayList<int[]> list; // 각 섬의 위치정보
    static int[] parent;
    static PriorityQueue<Edge> pq;

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            parent[a] = b;
        }
        else {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        list.add(new int[]{x, y});
        map[x][y] = snum;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            for (int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;

                if (map[nx][ny] == 1) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    map[nx][ny] = snum;
                    list.add(new int[]{nx, ny});
                }
            }
        }
    }

    // 다리를 만들 수 있는 섬의 각 지점 선택
    static void choose() {
        for (int i=0; i<landList.size(); i++) {
            ArrayList<int[]> now = landList.get(i);
            for (int j=0; j<now.size(); j++) {
                int x = now.get(j)[0];
                int y = now.get(j)[1];
                int nowN = map[x][y]; // 현재 섬 번호

                for (int next=0; next<4; next++) {
                    int nx = x + dx[next];
                    int ny = y + dy[next];

                    int bLength = 0; // 다리 길이
                    while (nx >= 0 && nx < n && ny >=0 && ny < m) {
                        if (map[nx][ny] == nowN) break; // 같은 섬이면 다리를 만들 수 없음
                    
                        else if (map[nx][ny] != 0) {
                            if (bLength > 1)
                                pq.add(new Edge(nowN, map[nx][ny], bLength));
                            break;
                        }
                        else { // 바다인 경우 다리 길이 연장
                            bLength++;
                        }
                        nx += dx[next];
                        ny += dy[next];
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

        visited = new boolean[n][m];
        map = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        landList = new ArrayList<ArrayList<int[]>>();
        list = new ArrayList<int[]>();
        // 섬 분리 작업
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j);
                    snum++;
                    landList.add(list);
                }
            }
        }
        pq = new PriorityQueue<Edge>();

        choose();

        int useEdge = 0;
        int ans = 0;

        parent = new int[snum];
        for (int i=0; i<parent.length; i++) {
            parent[i] = i;
        }

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                ans += now.v;
                useEdge++;
            }
        }

        if (useEdge == snum - 2)
            bw.write(ans + "\n");
        else
            bw.write(-1 + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
