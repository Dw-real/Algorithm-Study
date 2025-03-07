import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<t; i++) {
            int order = 0;
            LinkedList<int[]> printer = new LinkedList<int[]>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); 

            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                printer.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            while (true) {
                int[] first = printer.pollFirst();
                boolean flag = true;

                for (int j=0; j<printer.size(); j++) {
                    if (first[1] < printer.get(j)[1]) {
                        printer.add(first);

                        for (int k=0; k<j; k++)
                            printer.add(printer.poll());
                        
                        flag = false;
                        break;
                    }
                }

                if (flag == false) continue;
                order++;
                if (first[0] == m) {
                    sb.append(order).append("\n");
                    break;
                }
            }
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
