import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i=0; i<n - 1; i++) {
            pq.poll();
        }

        bw.write(pq.poll() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
