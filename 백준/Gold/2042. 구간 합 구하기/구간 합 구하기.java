import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;

    static void setTree(int size) {
        while (size != 1) {
            tree[size / 2] += tree[size];
            size--;
        }
    }

    static void changeVal(int index, long val) {
        long diff = val - tree[index];
        while (index > 0) {
            tree[index] = tree[index] + diff;
            index /= 2;
        }
    }

    static long getSum(int s, int e) {
        long sum = 0;

        while (s <= e) {
            if (s % 2 == 1) {
                sum += tree[s];
                s++;
            }
            if (e % 2 == 0) {
                sum += tree[e];
                e--;
            }
            s = s / 2;
            e = e / 2;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수
        int k = Integer.parseInt(st.nextToken()); // 구간 합을 구하는 횟수

        int treeHeight = 0;
        int length = n;

        while (length != 0) {
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int)Math.pow(2, treeHeight + 1);
        int leftStartIndex = treeSize / 2 - 1;
        tree = new long[treeSize + 1];

        for (int i=leftStartIndex + 1; i<=leftStartIndex + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1);

        for (int i=0; i<m + k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long a = Long.parseLong(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                changeVal(leftStartIndex + b, c);
            }
            else if (a == 2) {
                b += leftStartIndex;
                c += leftStartIndex;
                bw.write(getSum(b, (int)c) + "\n");
            }
            else
                return;
        }
        bw.flush(); 
        bw.close();
        br.close();
    }
}
