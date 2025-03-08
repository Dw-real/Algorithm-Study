import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] num = new int[n + 1];
        
        for (int i=2; i<=n; i++) {
            num[i] = i;
        }

        int ans = 0;
        int count = 0;

        outerLoop:
        for (int i=2; i<=n; i++) {
            if (num[i] == 0)
                continue;
            for (int j=i; j<=n; j+=i) {
                if (num[j] != 0) {
                    num[j] = 0;
                    count++;

                    if (count == k) {
                        ans = j;
                        break outerLoop;
                    }
                }
            }
        }

        bw.write(ans + "\n");
        
        bw.flush(); 
        bw.close();
        br.close();
    }
}
