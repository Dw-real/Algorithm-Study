import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (num == 0) {
                if (pq.isEmpty())
                    sb.append(num + "\n");
                else
                    sb.append(pq.poll() + "\n");
            }
            else {
                pq.add(num);
            }
        }

        bw.write(sb.toString() + "\n");

        br.close();
        bw.close();
    }
}