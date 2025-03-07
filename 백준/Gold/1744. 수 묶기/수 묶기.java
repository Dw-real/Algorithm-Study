import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()); // 수의 개수

        int sum = 0;
        PriorityQueue<Integer> plusNum = new PriorityQueue<Integer>(Collections.reverseOrder()); // 양수는 내림차순 정렬
        PriorityQueue<Integer> minusNum = new PriorityQueue<Integer>();
        int one = 0; // 1의 개수
        int zero = 0; // 0의 개수

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0)
                zero++;
            else if (num == 1)
                one++;
            else if (num > 0)
                plusNum.add(num);
            else
                minusNum.add(num);
        }

        while (plusNum.size() > 1) {
            int n1 = plusNum.remove();
            int n2 = plusNum.remove();
            sum += (n1 * n2);
        }

        while (minusNum.size() > 1) {
            int n1 = minusNum.remove();
            int n2 = minusNum.remove();
            sum += (n1 * n2);
        }

        // 양수 처리
        if (!plusNum.isEmpty()) {
            sum += plusNum.remove();
        }

        // 음수 처리
        if (!minusNum.isEmpty()) {
            if (zero == 0)
                sum += minusNum.remove();
        }
        
        // 1 처리
        sum += one;

        bw.write(sum + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
