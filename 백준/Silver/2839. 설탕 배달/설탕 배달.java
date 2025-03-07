import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while (true) {
            if (n < 0) {
                count = -1;
                break;
            }
            if (n % 5 == 0) {
                count += (n / 5);
                break;
            }
            else {
                n -= 3;
                count++;
            }
        }

        bw.write(count + "" + "\n");
        
        br.close();
        bw.close();
    }
}
