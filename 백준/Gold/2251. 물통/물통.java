import java.io.*;
import java.util.*;

class AB {
    int a;
    int b;

    public AB(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {
    // A->B, A->C, B->A, B->C, C->A, C->B로 이동
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited;
    static boolean[] ans;
    static int[] now;

    static void bfs() {
        Queue<AB> q = new ArrayDeque<AB>();
        q.add(new AB(0, 0));
        visited[0][0] = true;
        ans[now[2]] = true;

        while (!q.isEmpty()) {
            AB n = q.poll();
            int a = n.a;
            int b = n.b;
            int c = now[2] - a - b;

            for (int i=0; i<6; i++) {
                int[] next = {a, b, c};
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;
                
                if (next[receiver[i]] > now[receiver[i]]) { // 물이 넘칠 때
                    next[sender[i]] = next[receiver[i]] - now[receiver[i]];
                    next[receiver[i]] = now[receiver[i]]; 
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(new AB(next[0], next[1]));
                    if (next[0] == 0)  // A의 물의 양이 0일 때 C의 물 무게를 저장
                        ans[next[2]] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        now = new int[3]; // A, B, C 물의 양을 저장하는 배열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        now[2] = Integer.parseInt(st.nextToken());

        visited = new boolean[201][201];
        ans = new boolean[201];
        bfs();

        for (int i=0; i<ans.length; i++) {
            if (ans[i]) bw.write(i + " ");
        }
        bw.write("\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
