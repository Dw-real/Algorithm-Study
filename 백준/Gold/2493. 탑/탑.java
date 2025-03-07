import java.io.*;
import java.util.*;

class Top {
    int height;
    int index;

    public Top(int height, int index) {
        this.height = height;
        this.index = index;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Top> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            }
            else {
                while (!stack.isEmpty()) {
                    if (stack.peek().height > height)
                        break;
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(stack.peek().index).append(" ");
                }
            }
            stack.push(new Top(height, i + 1));
        }

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
