import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {    
        Stack stack = new Stack();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = reader.readLine();
        for (int i=0; i<Integer.parseInt(n); i++) {
            String order = reader.readLine();

            int orderN = order.charAt(0) - '0';

            switch (orderN) {
                case 1:
                    int num = Integer.parseInt(order.substring(2));
                    stack.push(num);
                    break;
                case 2:
                    writer.write(stack.pop() + "\n");
                    break;
                
                case 3:
                    writer.write(stack.getSize() + "\n");
                    break;
                
                case 4:
                    if (stack.getSize() == 0)
                        writer.write(1 + "\n");
                    else
                        writer.write(0 + "\n");
                    break;
                
                case 5:
                    writer.write(stack.peek() + "\n");
                    break;

                default:
                    break;
            }
        }

        reader.close();
        writer.close();
    }
}

class Stack {
    private int top;
    private List<Integer> stack;

    public Stack() {
        top = 0;
        stack = new ArrayList<Integer>();
    }

    public void push(int item) {
        stack.add(item);
        top++;
    }

    public int pop() {
        if (top == 0)
            return -1;
        top--; 
        
        return stack.remove(top);
    }

    public int peek() {
        if (top == 0)
            return -1;
        return stack.get(top-1);
    }

    public int getSize() {
        return stack.size();
    }
}
