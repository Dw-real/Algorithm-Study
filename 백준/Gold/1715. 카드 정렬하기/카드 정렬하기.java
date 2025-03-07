import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }

        int count = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            count += (a + b);
            pq.add(a + b);
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}