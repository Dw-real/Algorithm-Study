import java.io.*;

public class Main {
    static int count1; // 코드1 실행 횟수
    static int count2; // 코드2 실행 횟수

    static long fib(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    static long fibonacci(int n) {
        long[] f = new long[n + 1];
        f[1] = 1; f[2] = 1;
        for (int i=3; i<=n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            count2++;
        }
        return f[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        fib(n);
        fibonacci(n);
        bw.write(count1 + " " + count2 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
