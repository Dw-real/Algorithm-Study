import java.io.*;
import java.util.*;

public class Main {
    static boolean isPalindrome(int num) {
        int original = num;
        int reversed = 0;
        
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        
        return original == reversed;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] num = new int[b + 1];
        
        for (int i=2; i<=b; i++) {
            num[i] = i;
        }

        for (int i=2; i<=Math.sqrt(b); i++) {
            if (num[i] == 0)
                continue;
            for (int j=i+i; j<=b; j+=i) {
                num[j] = 0;
            } 
        }

        for (int i=a; i<=b; i++) {
            if (num[i] != 0) {
                if (isPalindrome(i)) {
                    bw.write(i + "\n");
                }
            }
        }
        bw.write(-1 + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
