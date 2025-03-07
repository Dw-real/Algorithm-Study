import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0}; // 상,하,좌,우
    static int[] dy = {0, 0, -1, 1};
    static int beginDirection = 3; // 뱀은 처음에 오른쪽으로 이동
    static Queue<Point> direction = new LinkedList<Point>();
    static Deque<Point> snake = new ArrayDeque<Point>();

    static int turnLeft(int direction) {
        return (direction == 0) ? 2 : (direction == 1) ? 3 : (direction == 2) ? 1 : 0; 
    }

    static int turnRight(int direction) {
        return (direction == 0) ? 3 : (direction == 1) ? 2 : (direction == 2) ? 0 : 1;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 보드의 크기
        int k = Integer.parseInt(br.readLine()); // 사과의 개수
        int time = 0; // 게임 실행 시간

        int[][] board = new int[n][n];
        board[0][0] = 2; // 뱀의 위치

        snake.offer(new Point(0, 0));

        // 사과 위치 정보
        for (int i=0; i<k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            board[r][c] = 1;
        }

        int l = Integer.parseInt(br.readLine()); // 방향 전환 정보

        for (int i=0; i<l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();

            if (c.equals("L")) // 왼쪽
                direction.offer(new Point(x, 0));
            else if (c.equals("D")) // 오른쪽
                direction.offer(new Point(x, 1));
        }
        
        int x = direction.peek().x;
        int c = direction.poll().y;

        while (true) {
            time++;

            int nx = snake.peekFirst().x + dx[beginDirection];
            int ny = snake.peekFirst().y + dy[beginDirection];
            
            if ((nx < 0 || nx >= n) || (ny < 0 || ny >= n) || board[nx][ny] == 2)
                break;
            
            if (board[nx][ny] == 1) { // 사과가 있다면
                board[nx][ny] = 2;

                snake.offerFirst(new Point(nx, ny));
            }
            else { // 사과가 없다면
                board[nx][ny] = 2;

                snake.offerFirst(new Point(nx, ny));

                board[snake.peekLast().x][snake.pollLast().y] = 0; // 몸 길이를 줄여서 꼬리가 위치한 칸 비우기
            }

            if (time == x) { // 방향 바꾸기
                if (c == 0) {
                    beginDirection = turnLeft(beginDirection);   
                }
                else {
                    beginDirection = turnRight(beginDirection);
                }

                if (!direction.isEmpty()) { // 방향 정보 갱신
                    x = direction.peek().x;
                    c = direction.poll().y;
                }
            }

        }

        bw.write(time + "" + "\n");

        br.close();
        bw.close();
    }
}
