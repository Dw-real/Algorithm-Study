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
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long result = gcd(a, b);

        while (result > 0) {
            bw.write(1 + "");
            result--;
        }
        bw.write("\n");
        
        bw.flush(); 
        bw.close();
        br.close();
    }
}
