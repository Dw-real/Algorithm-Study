import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long s = Long.parseLong(br.readLine());

        long sum = 0;
        for (long i=1; i<=s; i++) {
            sum += i;

            if (sum > s) {
                bw.write(i - 1 + "\n");
                break;
            }
            else if (sum == s) {
                bw.write(i + "\n");
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
