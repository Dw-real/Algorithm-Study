import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;

    static void setTree(int size) {
        while (size != 1) {
            if (tree[size / 2] > tree[size])
                tree[size / 2] = tree[size];
            size--;
        }
    }

    static long getMin(int s, int e) {
        long min = Long.MAX_VALUE;

        while (s <= e) {
            if (s % 2 == 1) {
                min = Math.min(min, tree[s]);
                s++;
            }
            if (e % 2 == 0) {
                min = Math.min(min, tree[e]);
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int length = n;

        while (length != 0) {
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int)Math.pow(2, treeHeight + 1);
        int leftStartIndex = treeSize / 2 - 1;

        tree = new long[treeSize + 1];
        for (int i=0; i<tree.length; i++) {
            tree[i] = Integer.MAX_VALUE;
        }
        // 데이터 입력 받기
        for (int i=leftStartIndex + 1; i<=leftStartIndex + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1);

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            s += leftStartIndex;
            e += leftStartIndex;
            bw.write(getMin(s, e) + "\n");
        }
        bw.flush(); 
        bw.close();
        br.close();
    }
}
