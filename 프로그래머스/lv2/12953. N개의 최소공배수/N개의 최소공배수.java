import java.util.*;

class Solution {
    public int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int solution(int[] arr) {
        if (arr.length == 1)
            return arr[0];
        int idx = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        while (idx != arr.length) {
            stack.push(lcm(stack.pop(), arr[idx++]));
        }
        return stack.pop();
    }
}