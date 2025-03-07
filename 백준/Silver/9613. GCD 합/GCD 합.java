import java.io.*;
import java.util.*;

public class Main {
    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            long[] arr = new long[n];

            for (int i=0; i<n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            
            long ans = 0;
            for (int i=0; i<arr.length; i++) {
                for (int j=i+1; j<arr.length; j++) {
                    ans += gcd(arr[i], arr[j]);
                }
            }
            bw.write(ans + "\n");
        }

        bw.flush(); 
        bw.close();
        br.close();
    }
}
