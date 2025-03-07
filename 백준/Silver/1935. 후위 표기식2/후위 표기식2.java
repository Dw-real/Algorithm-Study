import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 피연산자 개수

        double[] a = new double[n + 1];
        String str = br.readLine();

        for (int i=1; i<=n; i++) {
            a[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);

            if (c != '+' && c != '-' && c != '*' && c != '/') {
                int num = c - 'A' + 1;
                stack.push(a[num]);
            }
            else {
                if (c == '+') {
                    double num1 = stack.pop();
                    double num2 = stack.pop();
                    stack.push(num1 + num2);
                } else if (c == '-') {
                    double num1 = stack.pop();
                    double num2 = stack.pop();
                    stack.push(num2 - num1);
                } else if (c == '*') {
                    double num1 = stack.pop();
                    double num2 = stack.pop();
                    stack.push(num1 * num2);
                } else {
                    double num1 = stack.pop();
                    double num2 = stack.pop();
                    stack.push(num2 / num1);
                }
            }
        }

        bw.write(String.format("%.2f\n", stack.peek()));

        bw.flush();
        bw.close();
        br.close();
    }
}
