import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        

        st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num < x)
                sb.append(num).append(" ");
        }
        
        bw.write(sb.toString() + "\n");

        br.close();
        bw.close();
    }
}
