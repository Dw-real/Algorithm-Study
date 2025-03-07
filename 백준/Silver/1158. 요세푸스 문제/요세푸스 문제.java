import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        sb.append("<");

        for (int i=1; i<=n; i++) {
            queue.offer(i);
        }
        
        if (!(n == 1 && k == 1)) {
            while (true) {
                for (int i=0; i<k-1; i++) {
                    queue.addLast(queue.pollFirst());    
                }
                sb.append(queue.pollFirst()).append(", ");
                if (queue.size() == 1)
                    break;
            }
        }
        sb.append(queue.pollFirst()).append(">\n");

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
