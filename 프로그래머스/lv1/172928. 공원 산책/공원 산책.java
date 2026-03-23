import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static ArrayList<Point> list = new ArrayList<>(); // 장애물이 있는 위치

    public boolean isObstacle(int startX, int startY, int nextX, int nextY) {
        if (startX == nextX) { // 수평 이동
            int minY = Math.min(startY, nextY);
            int maxY = Math.max(startY, nextY);
            for (int y = minY; y <= maxY; y++) {
                for (Point p : list) {
                    if (p.x == startX && p.y == y) return true;
                }
            }
        }
        else if (startY == nextY) { // 수직 이동
            int minX = Math.min(startX, nextX);
            int maxX = Math.max(startX, nextX);
            for (int x = minX; x <= maxX; x++) {
                for (Point p : list) {
                    if (p.x == x && p.y == startY) return true;
                }
            }
        }
        return false;
    }

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int startX = 0;
        int startY = 0;
        for (int i=0; i< park.length; i++) {
            for (int j=0; j<park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                } else if (park[i].charAt(j) == 'X') {
                    list.add(new Point(i, j));
                }
            }
        }

        for (int i=0; i<routes.length; i++){
            String[] str = routes[i].split(" ");
            String op = str[0];
            int count = Integer.parseInt(str[1]);

            int nextX = startX;
            int nextY = startY;

            if (op.equals("N")) {
                nextX -= count;
            } else if (op.equals("S")) {
                nextX += count;
            } else if (op.equals("W")) {
                nextY -= count;
            } else if (op.equals("E")) {
                nextY += count;
            }

            if (nextX < 0 || nextX >= park.length || nextY < 0 || nextY >= park[nextX].length()) continue;
            if (isObstacle(startX, startY, nextX, nextY)) continue;

            startX = nextX;
            startY = nextY;
        }

        answer[0] = startX;
        answer[1] = startY;

        return answer;
    }

}