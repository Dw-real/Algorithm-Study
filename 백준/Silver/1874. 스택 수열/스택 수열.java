import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int num = 1; // 1부터 시작

        for (int i=0; i<arr.length; i++) {
            int target = arr[i];

            if (target >= num) {
                while (target >= num) {
                    stack.push(num++);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            } else {
                int top = stack.peek();

                if (top > target) {
                    bw.write("NO\n");
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }
                else {
                    stack.pop();
                    sb.append("-").append("\n");
                }
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
