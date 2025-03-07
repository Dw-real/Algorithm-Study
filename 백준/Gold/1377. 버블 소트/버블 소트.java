import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int value;
    int index;

    public Pair(int value, int index) {
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Pair p) { // value 기준 오름차순 정렬
        return this.value - p.value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Pair[] p = new Pair[n];

        for (int i = 0; i < n; i++) {
            p[i] = new Pair(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(p);

        int max = 0;

        for (int i=0; i<n; i++) {
            if (max < p[i].index - i)
                max = p[i].index - i;
        }

        bw.write(max + 1 + "" + "\n");
        
        bw.flush();
        br.close();
        bw.close();
    }
}
