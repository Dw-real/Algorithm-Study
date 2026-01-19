import java.io.*;
import java.util.*;

public class Main {
    static int[] romeNum = {1, 5, 10, 50};
    static ArrayList<Integer> nums;

    static void combination(int[] romeNum, int[] output, int start, int depth, int n) {
        if (depth == n) {
            if (!nums.contains(getSum(output))) {
                nums.add(getSum(output));
            }
            return;
        }
        for (int i=start; i<romeNum.length; i++) {
            output[depth] = romeNum[i];
            combination(romeNum, output, i, depth + 1, n);
        }
    }

    static int getSum(int[] arr) {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        nums = new ArrayList<>();

        combination(romeNum, new int[n], 0, 0, n);
        bw.write(nums.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
