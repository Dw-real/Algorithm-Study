import java.io.*;
import java.util.*;

class Node {
    int target;
    int value;

    public Node(int target, int value) {
        this.target = target;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 도로의 개수

        ArrayList<ArrayList<Node>> city = new ArrayList<ArrayList<Node>>();
        ArrayList<ArrayList<Node>> reverseCity = new ArrayList<ArrayList<Node>>();
        for (int i=0; i<=n; i++) {
            city.add(new ArrayList<Node>());
            reverseCity.add(new ArrayList<Node>());
        }

        // 진입 차수 배열
        int[] inDegree = new int[n + 1];
        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            city.get(start).add(new Node(end, time));
            reverseCity.get(end).add(new Node(start, time)); // 역방향 에지 정보 저장
            inDegree[end]++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sCity = Integer.parseInt(st.nextToken());
        int eCity = Integer.parseInt(st.nextToken());

        // 위상정렬
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(sCity);
        int[] result = new int[n + 1];
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node next : city.get(now)) {
                inDegree[next.target]--;
                result[next.target] = Math.max(result[next.target], result[now] + next.value);
                if (inDegree[next.target] == 0)
                    q.offer(next.target);
            }
        }

        // 위상정렬 reverse
        int resultCount = 0; // 1분도 쉬지않고 달려야하는 도시 수
        boolean[] visited = new boolean[n + 1];
        q = new LinkedList<Integer>();
        q.offer(eCity);
        visited[eCity] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node next : reverseCity.get(now)) {
                if (result[next.target] + next.value == result[now]) {
                    resultCount++;
                    if (!visited[next.target]) {
                        visited[next.target] = true;
                        q.offer(next.target);
                    }
                }
            }
        }
        bw.write(result[eCity] + "\n");
        bw.write(resultCount + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
