import java.io.*;
import java.util.*;

class Star implements Comparable<Star> {
    int start;
    int end;
    double distance;

    public Star(int start, int end, double distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    public int compareTo(Star s) {
        return (int)(this.distance - s.distance);
    }
}

public class Main {
    static PriorityQueue<Star> stars;
    static int[] parent;
    static ArrayList<double[]> point;

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
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()); // 별의 개수
        stars = new PriorityQueue<>();
        point = new ArrayList<>();
        parent = new int[n + 1];
        for (int i=1; i<=n; i++) {
            parent[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            point.add(new double[]{x, y});
        }
        
        for (int i=0; i<n; i++) {
            for (int j=i + 1; j<n; j++) {
                double distance = Math.sqrt(Math.pow(point.get(i)[0] - point.get(j)[0], 2) 
                                            + Math.pow(point.get(i)[1] - point.get(j)[1], 2));
                stars.add(new Star(i + 1, j + 1, distance));
            }
        }

        int useStar = 0;
        double result = 0;

        while (useStar < n - 1) {
            Star s = stars.poll();
            if (find(s.start) != find(s.end)) {
                union(s.start, s.end);
                useStar++;
                result += s.distance;
            }
        }
        bw.write(String.format("%.2f", result) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
