import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] value = new double[n];

        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            value[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        double ans = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c - '0' >= 17) { // 피연산자인 경우
                stack.push(value[c - '0' - 17]);
            } else {
                double a = stack.pop();
                double b = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                }
            }
        }

        ans = stack.pop();
        System.out.printf("%.2f\n", ans);
        br.close();
    }
}
