import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
            String command = st.nextToken();
            switch (command) {
                case "1":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "2":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "3":
                    if (!deque.isEmpty()) {
                        sb.append(deque.removeFirst()).append("\n");
                    }
                    else 
                        sb.append(-1).append("\n");
                    break;
                case "4":
                    if (!deque.isEmpty()) {
                        sb.append(deque.removeLast()).append("\n");
                    }
                    else 
                        sb.append(-1).append("\n");
                    break;
                case "5":
                    sb.append(deque.size()).append("\n");
                    break;
                case "6":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "7":
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    else 
                        sb.append(-1).append("\n");
                    break;
                case "8":
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    else 
                        sb.append(-1).append("\n");
                    break;
                default:
                    break;
            }
        }
        
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}