import java.awt.*;
import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static Point[] checkPoints;
    static int totalDistance;
    static int minDistance;

    static int getTotalDistance() {
        int total = 0;

        for (int i = 1; i < checkPoints.length; i++) {
            total += getDistance(checkPoints[i - 1].x, checkPoints[i - 1].y, checkPoints[i].x, checkPoints[i].y);
        }

        return total;
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static void getMinDistance() {
        minDistance = totalDistance;

        for (int i = 1; i < checkPoints.length - 1; i++) {
            int tmpDistance = totalDistance;

            tmpDistance -= getDistance(checkPoints[i - 1].x, checkPoints[i - 1].y, checkPoints[i].x, checkPoints[i].y);
            tmpDistance -= getDistance(checkPoints[i].x, checkPoints[i].y, checkPoints[i + 1].x, checkPoints[i + 1].y);
            tmpDistance += getDistance(checkPoints[i - 1].x, checkPoints[i - 1].y, checkPoints[i + 1].x, checkPoints[i + 1].y);

            minDistance = Math.min(minDistance, tmpDistance);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 체크 포인트 개수
        checkPoints = new Point[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            checkPoints[i] = new Point(x, y);
        }

        totalDistance = getTotalDistance();

        getMinDistance();

        bw.write(minDistance + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}