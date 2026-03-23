import java.util.*;

class Solution {
    static boolean[] visited = new boolean[3000000];

    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        visited[x] = true;
        q.add(new int[]{x, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int num = now[0];
            int count = now[1];

            if (num == y) {
                return count;
            }

            if (num * 2 >= 3000000) continue;
            if (num * 3 >= 3000000) continue;
            if (num + n >= 3000000) continue;

            if (!visited[num * 2]) {
                q.add(new int[]{num * 2, count + 1});
                visited[num * 2] = true;
            }
            if (!visited[num * 3]) {
                q.add(new int[]{num * 3, count + 1});
                visited[num * 3] = true;
            }
            if (!visited[num + n]) {
                q.add(new int[]{num + n, count + 1});
                visited[num + n] = true;
            }
        }
        return -1;
    }
}