import java.io.*;
import java.util.*;

class Main {
    static char[][] board = {{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
            {'z', 'x', 'c', 'v', 'b', 'n', 'm'}};

    static Set<Character> jaeum = Set.of('q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        char l = st.nextToken().charAt(0); // 왼손 검지 시작 지점
        char r = st.nextToken().charAt(0); // 오른손 검지 시작 지점

        int lx = 0;
        int ly = 0;
        int rx = 0;
        int ry = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == l) {
                    lx = i;
                    ly = j;
                } else if (board[i][j] == r) {
                    rx = i;
                    ry = j;
                }
            }
        }

        String str = br.readLine();

        int minTime = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board[j].length; k++) {
                    if (c == board[j][k]) {
                        if (jaeum.contains(c)) { // 자음인 경우 왼손 검지로 입력
                            int dist = Math.abs(lx - j) + Math.abs(ly - k);
                            minTime += dist + 1;
                            lx = j;
                            ly = k;
                        } else { // 모음인 경우 오른손 검지로 입력
                            int dist = Math.abs(rx - j) + Math.abs(ry - k);
                            minTime += dist + 1;
                            rx = j;
                            ry = k;
                        }
                    }
                }
            }
        }

        bw.write(minTime + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
