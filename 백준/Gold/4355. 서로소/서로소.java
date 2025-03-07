import java.io.*;
import java.util.*;

public class Main {
    static long euler(long n) {
        long result = n;

        for (int p=2; p<=Math.sqrt(n); p++) {
            if (n % p == 0) {
                result = result - result / p;
                while (n % p == 0) {
                    n /= p;
                }
            }
        }
        if (n > 1)
            result = result - result / n;

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            long n = Long.parseLong(br.readLine());
            if (n == 0)
                break;
            else if (n == 1)
                bw.write(0 + "\n");
            else
                bw.write(euler(n) + "\n");
        }

        bw.flush(); 
        bw.close();
        br.close();
    }
}
