import java.io.*;
import java.util.*;

class Pilar implements Comparable<Pilar> {
    int l;
    int h;

    public Pilar(int l, int h) {
        this.l = l;
        this.h = h;
    }

    @Override
    public int compareTo(Pilar p) {
        return this.l - p.l;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 기둥의 개수
        Pilar[] list = new Pilar[n];

        int highIdx = 0;
        int high = 0;
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken()); // 왼쪽 면의 위치
            int h = Integer.parseInt(st.nextToken()); // 높이

            list[i] = new Pilar(l, h);
        }

        Arrays.sort(list);

        for (int i=0; i<n; i++) {
            if (list[i].h > high) {
                high = list[i].h;
                highIdx = i;
            }
        }
        int ans = high;

        int leftHigh = 0;
        for (int i=0; i<highIdx; i++) {
            if (leftHigh < list[i].h)
                leftHigh = list[i].h;
            if (list[i].h >= list[i + 1].h) { // 다음 위치의 기둥보다 큰 경우
                ans += (leftHigh * (list[i + 1].l - list[i].l));
            }
            else {
                ans += (leftHigh * (list[i + 1].l - list[i].l));
            }
        }

        int rightHigh = 0;
        
        for (int i=n - 1; i>highIdx; i--) {
            if (rightHigh < list[i].h)
                rightHigh = list[i].h;
            if (list[i].h >= list[i - 1].h) {
                ans += (rightHigh * (list[i].l - list[i - 1].l));
            }
            else {
                ans += (rightHigh * (list[i].l - list[i - 1].l));
            }
        }

        System.out.println(ans);

        bw.flush();
        bw.close();
        br.close();
    }
}
