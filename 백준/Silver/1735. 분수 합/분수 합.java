import java.io.*;
import java.util.*;

public class Main {
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] num = new int[2]; // 분자
        int[] deno = new int[2]; // 분모
        for (int i=0; i<2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            num[i] = Integer.parseInt(st.nextToken());
            deno[i] = Integer.parseInt(st.nextToken());
        }    

        int ansDeno = deno[0] * deno[1] / gcd(deno[0], deno[1]);
        int ansNum = (ansDeno / deno[0] * num[0]) + (ansDeno / deno[1] * num[1]);

        bw.write(ansNum / gcd(ansNum, ansDeno) + " " + ansDeno / gcd(ansNum, ansDeno) + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
