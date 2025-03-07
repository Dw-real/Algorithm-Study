import java.io.*;
import java.util.*;

class Bridge implements Comparable<Bridge> {
    int h1;
    int h2;
    int k;

    public Bridge(int h1, int h2, int k) {
        this.h1 = h1;
        this.h2 = h2;
        this.k = k;
    }

    @Override
    public int compareTo(Bridge b) {
        return b.k - this.k;
    }
}

public class Main {
    static int[] parent;
    static ArrayList<Bridge> bridges;
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b)
            parent[a] = b;
        else
            parent[b] = a;
    }

    static int find(int a) {
        if (a == parent[a])
            return parent[a];
        else
            return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 집의 수
        int m = Integer.parseInt(st.nextToken()); // 다리의 수

        parent = new int[n + 1];
        for (int i=1; i<=n; i++) {
            parent[i] = i;
        }
        bridges = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken()); // 숭이의 출발 위치
        int e = Integer.parseInt(st.nextToken()); // 혜빈이의 위치

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            bridges.add(new Bridge(h1, h2, k));
        }

        Collections.sort(bridges);
        int max = 0;
        for (int i=0; i<bridges.size(); i++) {
            union(bridges.get(i).h1, bridges.get(i).h2);
            max = bridges.get(i).k;
            if (find(s) == find(e)) break;
        }

        if (parent[s] != parent[e]) 
            bw.write(0 + "\n");
        else
            bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
