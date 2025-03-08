import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();

        while (true) {
            String str = br.readLine();
            if (str.equals("."))
                break;
            
            Stack stack = new Stack();
            boolean vps = true;
            for (int i=0; i<str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == '(' || ch == '[')
                    stack.push(ch);
                else if (ch == ')') {
                    if (stack.peek() == '(')
                        stack.pop();
                    else {
                        vps = false;
                        break;
                    }
                }
                else if (ch == ']') {
                    if (stack.peek() == '[')
                    stack.pop();
                    else {
                        vps = false;
                        break;
                    }
                }
            }
            if (stack.isEmpty() && vps) {
                sb.append("yes" + "\n");
            }
            else {
                sb.append("no" + "\n");
            }
        }

        bw.write(sb.toString());
        
        br.close();
        bw.close();
    }
}

class Stack {
    private int top;
    private char array[];

    public Stack() {
        top = -1;
        array = new char[100];
    }

    public boolean isFull() {
        return top == 99;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(char item) {
        if (isFull()) {
            return;
        }
        else {
            array[++top] = item;
        }
    }

    public char pop() {
        if (!isEmpty()) {
            return array[top--];
        }
        return '\0';
    }

    public char peek() {
        if (!isEmpty()) {
            return array[top];
        }
        return '\0';  
    }
}
