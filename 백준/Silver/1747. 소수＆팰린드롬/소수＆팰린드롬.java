import java.io.*;

public class Main {
    static boolean isPalindrome(int prime) {
        char[] p = String.valueOf(prime).toCharArray();
        int start = 0;
        int end = p.length - 1;

        while (start < end) {
            if (p[start] != p[end])
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[10000001];

        for (int i=2; i<num.length; i++) {
            num[i] = i;
        }

        // 소수 판별
        for (int i=2; i<Math.sqrt(num.length); i++) {
            if (num[i] == 0)
                continue;
            for (int j=i+i; j<num.length; j+=i) {
                num[j] = 0;
            }
        }

        int i=n; // n 이상의 수

        while(true) {
            if (num[i] != 0) {
                int prime = num[i];

                if (isPalindrome(prime)) {
                    bw.write(prime + "\n");
                    break;
                }
            }
            i++;
        }

        bw.flush(); 
        bw.close();
        br.close();
    }
}
