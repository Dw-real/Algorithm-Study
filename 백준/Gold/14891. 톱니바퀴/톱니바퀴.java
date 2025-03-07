import java.io.*;
import java.util.*;

public class Main {
    static int[][] wheel;
    static int[] d; // 톱니바퀴의 회전 방향

    static void decideDir(int num) {
        // 왼쪽 톱니바퀴
        for (int i=num-1; i>0; i--) {
            if(wheel[i][2] != wheel[i + 1][6])
                d[i] = -d[i + 1];
            else
                break;
        }
        // 오른쪽 톱니바퀴
        for (int i=num+1; i<=4; i++) {
            if (wheel[i - 1][2] != wheel[i][6])
                d[i] = -d[i - 1];
            else
                break;
        }
    }

    static void rotateWheel() {
        for (int i=1; i<=4; i++) {
            if (d[i] == 1) // 시계방향 회전
                rotateClockwise(wheel[i]);
            else if (d[i] == -1) // 반시계방향 회전
                rotateCounterClockwise(wheel[i]);
        }
    }
    static void rotateClockwise(int[] arr) { // 시계 방향 회전
        int length = arr.length;
        int[] temp = new int[length];

        for (int i=0; i<length; i++) {
            temp[(i + 1) % length] = arr[i];
        }

        for (int i=0; i<length; i++) {
            arr[i] = temp[i];
        }
    }

    static void rotateCounterClockwise(int[] arr) { // 반시계 방향 회전
        int length = arr.length;
        int[] temp = new int[length];

        for (int i=0; i<length; i++) {
            temp[i] = arr[(i + 1) % length];
        }

        for (int i=0; i<length; i++) {
            arr[i] = temp[i];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        wheel = new int[5][8];

        // n극은 0 s극은 1
        for (int i=1; i<=4; i++) {
            String str = br.readLine();
            for (int j=0; j<8; j++) {
                wheel[i][j] = str.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i=0; i<k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken()); // 회전시킨 톱니바퀴 번호
            int dir = Integer.parseInt(st.nextToken()); // 1이면 시계방향, -1이면 반시계방향

            d = new int[5];
            d[num] = dir;
            decideDir(num); // 나머지 톱니바퀴 회전방향 결정
            rotateWheel(); // 톱니바퀴 회전
        }

        int ans = 0;
        if (wheel[1][0] == 1) ans += 1;
        if (wheel[2][0] == 1) ans += 2;
        if (wheel[3][0] == 1) ans += 4;
        if (wheel[4][0] == 1) ans += 8;

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
