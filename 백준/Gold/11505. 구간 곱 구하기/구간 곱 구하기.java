import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static int MOD;

    static void setTree(int size) {
        while (size != 1) {
            tree[size / 2] = tree[size / 2] * tree[size] % MOD; 
            size--;
        }
    }

    static void changeVal(int index, long val) {
        tree[index] = val;
        while (index > 1) {
            index /= 2;
            tree[index] = tree[index * 2] % MOD * tree[index * 2 + 1] % MOD;
        }
    }

    static long getMul(int s, int e) {
        long mul = 1;

        while (s <= e) {
            if (s % 2 == 1) {
                mul = mul * tree[s] % MOD;
                s++;
            }
            if (e % 2 == 0) {
                mul = mul * tree[e] % MOD;
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return mul;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int treeHeight = 0;
        int length = n;

        MOD  = 1000000007;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int)Math.pow(2, treeHeight + 1);
        int leftStartIndex = treeSize / 2 - 1;

        tree = new long[treeSize + 1];
        
        for (int i=0; i<tree.length; i++) {
            tree[i] = 1;
        }
        // 데이터 입력 받기
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
                bw.write(getMul(b, (int)c) + "\n");
            }
            else
                return;
        }
        bw.flush(); 
        bw.close();
        br.close();
    }
}
