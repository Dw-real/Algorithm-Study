class Solution {
    static boolean[][][] visited = new boolean[11][11][4];
    // 상좌하우
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public int solution(String dirs) {
        int answer = 0;
        // 캐릭터의 초기 위치
        int x = 5;
        int y = 5;
        int d = 0;

        for (int i=0; i<dirs.length(); i++) {
            char dir = dirs.charAt(i);
            if (dir == 'U') d = 0;
            if (dir == 'L') d = 1;
            if (dir == 'D') d = 2;
            if (dir == 'R') d = 3;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= 11 || ny < 0 || ny >= 11) continue;

            if (!visited[nx][ny][d]) {
                visited[nx][ny][d] = true;
                visited[x][y][(d + 2) % 4] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
}