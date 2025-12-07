import java.io.*;
import java.util.*;

class Main {
    static int[][] board;

    static boolean bingo() {
        int count = wCheck() + hCheck() + ldCheck() + rdCheck();
        return count >= 3;
    }

    static int wCheck() { // 가로
        int line = 0;
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == -1)
                    count++;
            }
            if (count == 5)
                line++;
        }
        return line;
    }

    static int hCheck() { // 세로
        int line = 0;
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (board[j][i] == -1)
                    count++;
            }
            if (count == 5)
                line++;
        }
        return line;
    }

    static int ldCheck() { // 왼쪽 대각선
        int count = 0;
        for (int i=0; i<5; i++) {
            if (board[i][i] == -1)
                count++;
        }
        if (count == 5) {
            return 1;
        } else {
            return 0;
        }
    }

    static int rdCheck() { // 오른쪽 대각선
        if (board[0][4] == -1 && board[1][3] == -1 && board[2][2] == -1 && board[3][1] == -1 && board[4][0] == -1)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        outer:
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                count++;
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (board[k][l] == num) {
                            board[k][l] = -1;
                        }
                    }
                }
                if (bingo()) {
                    break outer;
                }
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
