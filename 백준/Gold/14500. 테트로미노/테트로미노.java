import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int[][][] block = { // 테트로미노 종류
            {{0, 1}, {0, 2}, {0, 3}},
            {{1, 0}, {2, 0}, {3, 0}},
            {{0, 1}, {1, 0}, {1, 1}},
            {{1, 0}, {2, 0}, {2, 1}},
            {{1, 0}, {0, 1}, {0, 2}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{0, 1}, {-1, 1}, {-2, 1}},
            {{0, -1}, {1, -1}, {2, -1}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 1}, {0, 2}, {-1, 2}},
            {{0, 1}, {0, 2}, {1, 2}},
            {{1, 0}, {1, 1}, {2, 1}},
            {{1, 0}, {1, -1}, {2, -1}},
            {{0, 1}, {-1, 1}, {-1, 2}},
            {{0, 1}, {1, 1}, {1, 2}},
            {{0, 1}, {0, 2}, {1, 1}},
            {{1, 0}, {1, 1}, {2, 0}},
            {{1, 0}, {1, -1}, {2, 0}},
            {{1, 0}, {1, -1}, {1, 1}}
    };
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE; // 종이 위에 테트로미노 하나를 올려놓았을 때 테트로미노가 놓인 칸의 합의 최대치

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                for (int k=0; k<19; k++) {
                    int sum = board[i][j];
                    boolean flag = true; // 테트로미노를 올려놓을 수 있는지 여부
                    for (int l=0; l<3; l++) {
                        int nx = i + block[k][l][0];
                        int ny = j + block[k][l][1];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            flag = false;
                            break;
                        }

                        sum += board[nx][ny];
                    }
                    if (flag)
                        max = Math.max(max, sum);
                }
            }
        }
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}