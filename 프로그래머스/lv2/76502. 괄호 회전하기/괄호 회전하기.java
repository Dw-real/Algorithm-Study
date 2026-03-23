import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i=0; i<s.length(); i++) {
            String tmp = rotate(s, i);
            if (isValid(tmp))
                answer++;
        }
        return answer;
    }

    public String rotate(String s, int count) {
        String tmp = "";
        int index = 0;
        int[] order = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            if (i - count >= 0) 
                index = i - count;
            else
                index = i - count + s.length();
            order[index] = i;
        }
        for (int i=0; i<order.length; i++) {
            tmp += s.charAt(order[i]);
        }
        return tmp;
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if ((c == '(' || c == '{' || c == '[') || stack.isEmpty()) {
                stack.push(c);
            }
            else if (!stack.isEmpty()){
                if (c == ')') {
                    if (stack.peek() != '(') {
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                if (c == '}') {
                    if (stack.peek() != '{') {
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                if (c == ']') {
                    if (stack.peek() != '[') {
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
             }
        }
        if (!stack.isEmpty())
            return false;
        else
            return true;
    }
}