import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();

        boolean valid = true;

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<') {
                valid = false;
                while (!stack.isEmpty()) {
                    bw.write(stack.pop());
                }
            } else if (c == '>') {
                valid = true;
                bw.write(c);
            } else if (valid && c == ' ') {
                while (!stack.isEmpty()) {
                    bw.write(stack.pop());
                }
                bw.write(c);
            }
            if (!valid) {
                bw.write(c);
            } else if (c != ' ' && c != '>') {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}