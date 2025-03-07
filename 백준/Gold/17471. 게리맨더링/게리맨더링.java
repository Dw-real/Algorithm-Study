import java.io.*;
import java.util.*;

public class Main {
    static int n; // 구역의 개수
    static int[] population; // 각 구역의 인구수
    static boolean[] visited;
    static ArrayList<Integer>[] city; // 도시의 구역정보
    static int min = Integer.MAX_VALUE;

    static void divideArea(int count) {
        if (count == n) {
            ArrayList<Integer> group1 = new ArrayList<>();
            ArrayList<Integer> group2 = new ArrayList<>();

            for (int i=1; i<=n; i++) {
                if (visited[i]) group1.add(i);
                else group2.add(i);
            }

            if (group1.isEmpty() || group2.isEmpty())
                return;

            if (bfs(group1) && bfs(group2))
                getMin();
            return;
        }
        visited[count] = true;
        divideArea(count + 1);

        visited[count] = false;
        divideArea(count + 1);
    }

    static boolean bfs(ArrayList<Integer> group) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[n + 1];
        check[group.get(0)] = true;
        q.add(group.get(0));

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : city[now]) {
                if (group.contains(next) && !check[next]) {
                    q.add(next);
                    check[next] = true;
                }
            }
        }

        for (int i : group) {
            if (!check[i])
                return false;
        }

        return true;
    }

    static void getMin() {
        int sum1 = 0;
        int sum2 = 0;

        for (int i=1; i<=n; i++) {
            if (visited[i]) sum1 += population[i];
            else sum2 += population[i];
        }

        int diff = Math.abs(sum1 - sum2);
        min = Math.min(min, diff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        population = new int[n + 1];
        visited = new boolean[n + 1];
        city = new ArrayList[n + 1];

        for (int i=0; i<=n; i++) {
            city[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int link = Integer.parseInt(st.nextToken()); // 연결된 구역의 수
            for (int j=1; j<=link; j++) {
                int area = Integer.parseInt(st.nextToken());

                city[i].add(area);
                city[area].add(i);
            }
        }

        divideArea(0);

        if (min == Integer.MAX_VALUE)
            bw.write(-1 + "\n");
        else
            bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
