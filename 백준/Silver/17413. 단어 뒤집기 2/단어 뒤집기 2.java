import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Character> stack = new Stack<Character>();

        String str = br.readLine();
        
        boolean tag = false;

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '<') {
                tag = true;
                while (!stack.isEmpty()) {
                    bw.write(stack.pop());
                }
            }
            else if (str.charAt(i) == '>') {
                tag = false;
                bw.write(str.charAt(i));
            }
            else if (str.charAt(i) == ' ' && !tag) {
                while (!stack.isEmpty()) {
                    bw.write(stack.pop());
                }
                bw.write(str.charAt(i));
            }
            if (tag) {
                bw.write(str.charAt(i));
            }
            if (!tag && str.charAt(i) != '>' && str.charAt(i) != ' ') {
                stack.add(str.charAt(i));
            } 
        }
        
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
        bw.write("\n");

        br.close();
        bw.close();
    }
}
