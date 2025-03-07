import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();

        int sum = 0;
        int tmp = 1;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (stack.isEmpty() || (c == '(' || c == '[')) {
                if (c == '(') {
                    tmp *= 2;
                }
                else if (c == '[') {
                    tmp *= 3;
                }
                stack.push(c);
            }
            else if (!stack.isEmpty()) {
                if (c == ')') {
                    if (stack.peek() != '(')
                        break;
                    if (str.charAt(i - 1) == '(')
                        sum += tmp;
                    stack.pop();
                    tmp /= 2;
                }
                if (c == ']') {
                    if (stack.peek() != '[')
                        break;
                    if (str.charAt(i - 1) == '[')
                        sum += tmp;
                    stack.pop();
                    tmp /= 3;
                }
            }
        }

        if (!stack.isEmpty())
            bw.write(0 +"\n");
        else
            bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
