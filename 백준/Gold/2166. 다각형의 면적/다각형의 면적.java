import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] x = new long[n + 1];
        long[] y = new long[n + 1];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }
        x[n] = x[0]; // 마지막 점과 처음 점도 ccw에 포함
        y[n] = y[0]; 

        double result = 0;
        for (int i=0; i<n; i++) {
            result += (x[i] * y[i + 1]) - (x[i + 1] * y[i]);
        }
        String ans = String.format("%.1f", Math.abs(result) / 2.0);
        
        bw.write(ans + "\n");
        
        bw.flush(); 
        bw.close();
        br.close();
    }
}
