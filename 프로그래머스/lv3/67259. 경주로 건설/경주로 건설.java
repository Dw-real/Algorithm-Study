import java.util.*;

class Road {
    int x;
    int y;
    int cost;
    int dir;

    public Road(int x, int y, int cost, int dir) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }
}

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][][] minCost;
    static int answer = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        minCost = new int[board.length][board[0].length][4];
        for (int i=0; i <minCost.length ; i++) {
            for (int j=0; j< minCost[i].length; j++) {
                Arrays.fill(minCost[i][j], 99999999);
            }
        }
        bfs(board);
        return answer;
    }

    public void bfs(int[][] board) {
        Queue<Road> q = new LinkedList<>();
        q.add(new Road(0, 0, 0, 1));
        q.add(new Road(0, 0, 0, 3));

        while (!q.isEmpty()) {
            Road now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            int cost = now.cost;
            int dir = now.dir;

            if (nowX == board.length - 1 && nowY == board[0].length - 1) {
                answer = Math.min(answer, cost);
                continue;
            }

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;
                if (board[nx][ny] == 1) continue;

                if (i == dir && minCost[nx][ny][i] > cost + 100) { // 방향이 같은 경우
                    minCost[nx][ny][i] = cost + 100;
                    q.add(new Road(nx, ny, cost + 100, i));
                } else if (i != dir && minCost[nx][ny][i] > cost + 600){
                    minCost[nx][ny][i] = cost + 600;
                    q.add(new Road(nx, ny, cost + 600, i));
                }
            }
        }
    }
}