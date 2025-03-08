import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = new boolean[10000];

        for (int i=1; i<10000; i++) {
            int sum = i;
            int num = i;

            while (num != 0) {
                sum += (num % 10);
                num /= 10;
            }

            if (sum < 10000)
                arr[sum] = true;
        }

        for (int i=1; i<10000; i++) {
            if (!arr[i])
                bw.write(i + "" + "\n");
        }

        bw.close();
    }
}
