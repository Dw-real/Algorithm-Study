import java.util.*;

class Node implements Comparable<Node> {
    int index;
    int time;

    public Node(int index, int time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(Node n) {
        return this.time - n.time;
    }
}

class Solution {
    static int[] time;
    static ArrayList<Node>[] routes;
    static int[] answer;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        time = new int[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);

        routes = new ArrayList[n + 1];
        for (int i=0; i<=n; i++) {
            routes[i] = new ArrayList<>();
        }
        for (int i=0; i<paths.length; i++) {
            int s = paths[i][0];
            int e = paths[i][1];
            int t = paths[i][2];

            routes[s].add(new Node(e, t));
            routes[e].add(new Node(s, t));
        }
        dijkstra(gates, summits);

        return answer;
    }

    public void dijkstra(int[] gates, int[] summits) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int gate : gates) {
            pq.offer(new Node(gate, 0));
            time[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (isSummit(now.index, summits))
                continue;
            if (time[now.index] < now.time)
                continue;
            for (Node next : routes[now.index]) {
                int t = Math.max(now.time, next.time);
                if (time[next.index] > t) {
                    time[next.index] = t;
                    pq.offer(new Node(next.index, time[next.index]));
                }
            }
        }

        Arrays.sort(summits);

        int minIndex = -1;
        int minTime = Integer.MAX_VALUE;

        for (int summit : summits) {
            if (time[summit] < minTime) {
                minIndex = summit;
                minTime = time[summit];
            }
        }

         answer = new int[]{minIndex, minTime};
    }
    
    public boolean isSummit(int index, int[] summits) {
        for (int summit : summits) {
            if (summit == index)
                return true;
        }
        return false;
    }
}