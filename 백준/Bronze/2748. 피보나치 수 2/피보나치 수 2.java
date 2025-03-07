import java.io.*;

public class Main {
    static long[] cache;
    
    static long fibonacci(int n) {
        if (cache[n] == -1)
            cache[n] = fibonacci(n-1) + fibonacci(n-2);

        return cache[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        cache = new long[n+1];

        for (int i=0; i<cache.length; i++) {
            cache[i] = -1;
        }
        cache[0] = 0;
        cache[1] = 1;

        bw.write(fibonacci(n) + "" + "\n");

        br.close();
        bw.close();
    }
}
