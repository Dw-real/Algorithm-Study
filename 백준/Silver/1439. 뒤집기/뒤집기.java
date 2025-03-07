import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String num = br.readLine();

        boolean one = true; // 0또는 1

        int start = num.charAt(0) - '0';
        int oneArea = 0;
        int zeroArea = 0;
        if (start == 0) {
            zeroArea = 1; // 0인 부분
            one = false;
        } else if (start == 1) {
            oneArea = 1; // 1인 부분
        }

        for (int i=1; i<num.length(); i++) {
            int next = num.charAt(i) - '0';
            if (start != next && one) {
                one = false;
                start = next;
                zeroArea++;
            }
            else if (start != next && !one) {
                one = true;
                start = next;
                oneArea++;
            }
        }

        int min = Math.min(oneArea, zeroArea);
        bw.write(min + "\n");

        br.close();
        bw.close();
    }
}