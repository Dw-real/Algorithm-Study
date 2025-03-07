import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 수열의 크기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int[] ans = new int[n]; // 정답 배열

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0); // 0번 인덱스

        for (int i=1; i<n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) { // 스택이 비어있지 않고 현재 수열 값이 arr top에 해당하는 수보다 큰 경우
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        for (int i=0; i<n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
