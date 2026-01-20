import java.io.*;
import java.util.*;

class Direction {
    int time;
    String dir;

    public Direction(int time, String dir) {
        this.time = time;
        this.dir = dir;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static int n;
    static int time = 0;
    static Queue<Direction> dirs = new LinkedList<>();

    static void startGame() {
        Deque<int[]> snake = new ArrayDeque<>();
        snake.offerFirst(new int[]{0, 0});
        int dir = 3; // 뱀은 처음에 오른쪽으로 이동

        int t = dirs.peek().time;
        String d = dirs.poll().dir;

        while (true) {
            time++;

            int nowX = snake.peekFirst()[0];
            int nowY = snake.peekFirst()[1];

            int nx = nowX + dx[dir];
            int ny = nowY + dy[dir];

            // 벽 또는 자기자신의 몸과 부딪히면 게임 종료
            if ((nx < 0 || nx >= n) || (ny < 0 || ny >= n) || board[nx][ny] == 2)
                break;

            if (board[nx][ny] == 1) { // 사과가 있다면 사과를 없애고 꼬리를 움직이지 않음
                snake.offerFirst(new int[]{nx, ny});
                board[nx][ny] = 2;
            } else if (board[nx][ny] == 0) { // 사과가 없다면 몸 길이를 줄여서 꼬리가 위치한 칸을 비움
                snake.offerFirst(new int[]{nx, ny});
                board[nx][ny] = 2;
                board[snake.peekLast()[0]][snake.pollLast()[1]] = 0;
            }

            if (t == time) {
                if (d.equals("L")) {
                    dir = turnLeft(dir);
                } else if (d.equals("D")) {
                    dir = turnRight(dir);
                }

                if (!dirs.isEmpty()) {
                    t = dirs.peek().time;
                    d = dirs.poll().dir;
                }
            }
        }
    }

    static int turnLeft(int dir) {
        return (dir == 0) ? 2 : (dir == 1) ? 3 : (dir == 2) ? 1 : 0;
    }

    static int turnRight(int dir) {
        return (dir == 0) ? 3 : (dir == 1) ? 2 : (dir == 2) ? 0 : 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        int k = Integer.parseInt(br.readLine()); // 사과의 개수

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r - 1][c - 1] = 1;
        }

        board[0][0] = 2; // 뱀의 시작 위치

        int l = Integer.parseInt(br.readLine()); // 방향 전환 횟수
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();

            dirs.add(new Direction(x, c));
        }

        startGame();

        bw.write(time + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
