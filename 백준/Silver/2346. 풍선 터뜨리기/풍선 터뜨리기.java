import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        Deque<int[]> deque = new ArrayDeque<int[]>();
        
        for (int i=1; i<=n; i++) {
            int[] arr = new int[2];
            arr[0] = i;
            arr[1] = Integer.parseInt(st.nextToken());    
            deque.add(arr);
        }
        
        int move = deque.peekFirst()[1];
        sb.append(deque.pollFirst()[0] + " ");

        while (deque.size() > 1) {
            if (move > 0) {
                for (int i=0; i<move; i++){
                    deque.add(deque.pollFirst());
                }
                move = deque.peekLast()[1];
                sb.append(deque.pollLast()[0] + " ");
            }
            else {
                for (int i=move; i<0; i++) {
                    deque.addFirst(deque.pollLast());
                }
                move = deque.peekFirst()[1];
                sb.append(deque.pollFirst()[0] + " ");
            }
        }

        sb.append(deque.poll()[0] + "\n");

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}