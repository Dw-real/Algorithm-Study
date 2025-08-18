import java.io.*;
import java.util.PriorityQueue;

class Serial implements Comparable<Serial> {
    String serialNum;
    int length;

    public Serial(String serialNum, int length) {
        this.serialNum = serialNum;
        this.length = length;
    }

    public int getSum(String serialNum) {
        int sum = 0;
        for (int i = 0; i < serialNum.length(); i++) {
            if (serialNum.charAt(i) - '0' < 10) { // 숫자인 경우만 더함
                sum += (serialNum.charAt(i) - '0');
            }
        }
        return sum;
    }

    @Override
    public int compareTo(Serial s) {
        if (this.length == s.length && this.getSum(this.serialNum) == s.getSum(s.serialNum)) { // 길이와 자리수의 합이 같은 경우
            return this.serialNum.compareTo(s.serialNum);
        } else if (this.length == s.length && this.getSum(this.serialNum) != s.getSum(s.serialNum)) {
            return this.getSum(this.serialNum) - s.getSum(s.serialNum);
        } else {
            return this.length - s.length;
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Serial> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Serial serial = new Serial(str, str.length());
            pq.add(serial);
        }

        while (!pq.isEmpty()) {
            bw.write(pq.poll().serialNum + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
