import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        // 최솟값과 최댓값의 차이만큼 배열 선언
        boolean[] check = new boolean[(int)(max - min + 1)];

        for (long i=2; i*i<=max; i++) {
            long pow = i * i;
            long startIndex = min / pow;

            if (min % pow != 0)
                startIndex++;
            
            for (long j=startIndex; pow * j <= max; j++)
                check[(int)((j * pow) - min)] = true;
        }
        
        int count = 0;

        for (int i=0; i<= max-min; i++) {
            if (!check[i])
                count++;
        }

        bw.write(count + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
