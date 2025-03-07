import java.io.*;
import java.util.*;

public class Main {
    static int n;

    static void dfs(int num, int exp) {
        if (exp == n) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }
        for (int i=0; i<10; i++) {
            if (i % 2 == 0)
                continue;
            if (isPrime(num * 10 + i)) {
                dfs(num * 10 + i, exp + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        for (int i=2; i<= num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine()); // 자릿수

        // dfs 실행
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        bw.flush(); 
        bw.close();
        br.close();
    }
}
