import java.io.*;

public class Main {
    static int[] mushroom = new int[10];

    static int getDiff(int n) {
        return Math.abs(100 - n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 10; i++) {
            int score = Integer.parseInt(br.readLine());
            mushroom[i] = score;
        }


        int minDiff = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += mushroom[i];
            int diff = getDiff(sum);

            if (diff < minDiff) {
                minDiff = diff;
                result = sum;
            } else if (diff == minDiff) {
                result = Math.max(result, sum);
            }
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
