import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];

        long max = 0;
        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            if (score[i] > max)
                max = score[i];
            sum += score[i];    
        }

        bw.write(sum * 100.0 / max / n + "" + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
