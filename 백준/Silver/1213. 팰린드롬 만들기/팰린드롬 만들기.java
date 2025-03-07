import java.io.*;
import java.util.*;

public class Main {
    static String palindrome(Map<Character, Integer> dic) {
        String ans = new String();
        StringBuilder half = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : dic.entrySet()) {
            for (int i=0; i<entry.getValue() / 2; i++) {
                half.append(entry.getKey());
            }
        }

        ans += half.toString();
        
        for (Map.Entry<Character, Integer> entry : dic.entrySet()) {
            if (entry.getValue() % 2 == 1)
                ans += entry.getKey();
        }
        ans += half.reverse().toString();

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Character, Integer> dic = new TreeMap<Character, Integer>();

        String s = br.readLine();

        int sum = 0;

        for (int i=0; i<s.length(); i++) {
            if (dic.containsKey(s.charAt(i))) {
                int count = dic.get(s.charAt(i));
                count += 1;
                dic.put(s.charAt(i), count);
            }
            else {
                dic.put(s.charAt(i), 1);
            }
        }

        for (int count : dic.values()) {
            sum += (count % 2);
        }

        if (sum > 1) { // 홀수개인 문자가 2개 이상인 경우 팰린드롬 생성 불가
            bw.write("I'm Sorry Hansoo\n");
        }
        else {
            bw.write(palindrome(dic) + "\n");
        }

        br.close();
        bw.close();
    }
}
