import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int ans = 1;

        while (true) {
            String num = String.valueOf(ans);
            int sum = 0;

            for (int i=0; i<num.length(); i++) {
                sum += num.charAt(i) - '0';
            }

            if ((sum += ans) == n) {
                break;
            }

            if (ans >= 1000000) {
                ans = 0;
                break;
            }
            ans++;
        }

        bw.write(ans + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
