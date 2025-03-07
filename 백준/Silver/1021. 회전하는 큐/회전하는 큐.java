import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        LinkedList<Integer> dq = new LinkedList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        int count = 0;

        for (int i=1; i<=n; i++) {
            dq.offer(i);
        }

        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i=0; i<m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<m; i++) {
            int index = dq.indexOf(arr[i]);
            int half = dq.size() / 2;
            
            if (index <= half) {
                while (arr[i] != dq.getFirst()) {
                    dq.addLast(dq.pollFirst());
                    count++;
                }
            }
            else {
                while (arr[i] != dq.getFirst()) {
                    dq.addFirst(dq.pollLast());
                    count++;
                }
            }
            dq.pollFirst();
        }

        bw.write(count + "" + "\n");

        br.close();
        bw.close();
    }
}
