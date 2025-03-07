import java.io.*;

public class Main {
    static long[] cache = new long[1002];
    static int mod = 10007;

    static long tile(int n) {
        if (cache[n] == -1)
            cache[n] = (tile(n-1) + tile(n-2)) % mod;
        
        return cache[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<cache.length; i++) {
            cache[i] = -1;
        }
        cache[0] = 0;
        cache[1] = 1;
        
        bw.write(tile(n+1) + "" + "\n");
        
        br.close();
        bw.close();
    }
}
