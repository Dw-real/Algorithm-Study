import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 3) {
            if (n % 3 != 0) {
                sb.append(n % 3);
                n /= 3;
            } else {
                sb.append(4);
                n = n / 3 - 1;
            }
        }
        if (n == 3)
            sb.append(4);
        else
            sb.append(n);
        return sb.reverse().toString();
    } 
}