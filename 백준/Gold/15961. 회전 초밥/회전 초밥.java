import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[n];
        int[] eated = new int[d + 1]; // 

        for (int i=0; i<n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        int count = 0; // 초기 설정

        for (int i=0; i<k; i++) {
            if (eated[sushi[i]] == 0) { // 먹지않은 초밥의 종류라면
                count++;
            }   
            eated[sushi[i]]++;
        }

        int max = count;

        for (int i=0; i<n; i++) {
            int j = (i + k) % n; // 이후 먹는 초밥

            eated[sushi[i]]--;
            if (eated[sushi[i]] == 0)
                count--;

            if (eated[sushi[j]] == 0)
                count++;

            eated[sushi[j]]++;

            if (max <= count) {
                if (eated[c] == 0) { // 쿠폰 초밥을 먹지 않았다면
                    max = count + 1;
                }
                else {
                    max = count;
                }
            }
        }

        bw.write(max + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
