import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long[] num = new long[10000001];

        for (int i=2; i<num.length; i++) {
            num[i] = i;
        }

        // 소수 판별
        for (int i=2; i<=Math.sqrt(num.length); i++) {
            if (num[i] == 0)
                continue;
            for (int j=i+i; j<num.length; j+=i) {
                num[j] = 0;
            }
        }
        int count = 0;

        for (int i=2; i<num.length; i++) {
            if (num[i] != 0) {
                long prime = num[i]; // 소수
                while ((double)num[i] <= (double)b/(double)prime) {
                    if ((double)num[i] >= (double)a/(double)prime)
                        count++;
                    prime *= num[i];
                }
            }
        }

        bw.write(count + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
