import java.io.*;
import java.util.*;

public class Main {
    static int[][] tree;

    // 전위 순회
    static void preOrder(int now) {
        if (now == -1)
            return;
        System.out.print((char)(now + 'A'));
        preOrder(tree[now][0]);
        preOrder(tree[now][1]);
    }

    // 중위 순회
    static void inOrder(int now) {
        if (now == -1)
            return;
        inOrder(tree[now][0]);
        System.out.print((char)(now + 'A'));
        inOrder(tree[now][1]);
    }

    // 후위 순회
    static void postOrder(int now) {
        if (now == -1)
            return;
        postOrder(tree[now][0]);
        postOrder(tree[now][1]);
        System.out.print((char)(now + 'A'));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()); // 노드의 개수

        tree = new int[26][2];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left == '.') {
                tree[node][0] = -1;
            }
            else {
                tree[node][0] = left - 'A'; 
            }
            if (right == '.') {
                tree[node][1] = -1;
            }
            else {
                tree[node][1] = right - 'A';
            }
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();

        bw.flush(); 
        bw.close();
        br.close();
    }
}
