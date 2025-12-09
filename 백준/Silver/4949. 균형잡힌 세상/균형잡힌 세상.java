import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            if (str.equals("."))
                break;

            boolean valid = true;
            for (char c : str.toCharArray()) {
                if (c == '(' || c == '[')
                    stack.push(c);
                else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        valid = false;
                        break;
                    }
                    stack.pop();
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        valid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty() && valid) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
