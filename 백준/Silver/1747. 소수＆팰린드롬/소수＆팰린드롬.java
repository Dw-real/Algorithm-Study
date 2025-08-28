import java.io.*;

public class Main {

    static boolean isPrime(int n) {
        if (n == 1)
            return false;

        for (int i=2; i<= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static boolean isPalindrome(int n) {
        String number = String.valueOf(n);
        int start = 0;
        int end = number.length() - 1;

        while (start <= end) {
            if (number.charAt(start) != number.charAt(end))
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

        while (!isPrime(n) || !isPalindrome(n)) {
            n++;
        }

        bw.write(n + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
