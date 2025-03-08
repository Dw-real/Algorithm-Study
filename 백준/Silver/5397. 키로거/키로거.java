import java.io.*;
import java.util.*;

public class Main {
    static String getPassword(String str) {
        StringBuilder pw = new StringBuilder();
        Stack<Character> left = new Stack<Character>(); 
        Stack<Character> right = new Stack<Character>();

        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);

            switch (c) {
                case '-':
                    if (!left.isEmpty())
                        left.pop();    
                    break;
                case '<':
                    if (!left.isEmpty())
                        right.push(left.pop());
                    break;
                case '>':
                    if (!right.isEmpty())
                        left.push(right.pop());
                    break;
                default :
                    left.push(c);
                    break;
            }
        }
        
        while (!left.isEmpty()) {
            pw.append(left.pop());
        }
        
        pw.reverse();

        while (!right.isEmpty()) {
            pw.append(right.pop());
        }

        return pw.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            sb.append(getPassword(str) + "\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
