import java.io.*;
import java.util.*;

public class Main {
    static int getAncestor(int x , int y, int depth1, int depth2, int[] parent) {
        if (depth1 > depth2) {
            while (depth1 != depth2) {
                depth1--;
                x = parent[x];
            }
        } 
        else if (depth1 < depth2) {
            while (depth1 != depth2) {
                depth2--;
                y = parent[y];
            }
        } 
        while (x != y) {
            x = parent[x];
            y = parent[y];
        }
        
        return x;
    }

    static int getDepth(int[] parent, int i) {
        int depth = 0;
        int start = parent[i];

        while (start != 0) {
            start = parent[start];
            ++depth;
        }

        return depth;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] parent = new int[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()); // 부모
            int b = Integer.parseInt(st.nextToken()); // 자식
            parent[b] = a;

            for (int j=0; j<n-2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken()); // 부모
                b = Integer.parseInt(st.nextToken()); // 자식

                parent[b] = a;
            }
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int depth1 = getDepth(parent, x);
            int depth2 = getDepth(parent, y);
            
            bw.write(getAncestor(x, y, depth1, depth2, parent) + "" + "\n");
        }

        br.close();
        bw.close();
    }
}
