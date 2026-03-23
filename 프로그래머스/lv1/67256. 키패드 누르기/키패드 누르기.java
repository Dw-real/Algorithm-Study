class Solution {
    static int[][] keyPad = {{1, 2 ,3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 손가락의 초기 위치
        int leftX = 3, leftY = 0;
        int rightX = 3, rightY = 2;

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7){
                answer += "L";
                leftX = findIndex(number)[0];
                leftY = findIndex(number)[1];
            }
            else if (number == 3 || number == 6 || number == 9) {
                answer += "R";
                rightX = findIndex(number)[0];
                rightY = findIndex(number)[1];
            } else {
                int tx = findIndex(number)[0];
                int ty = findIndex(number)[1];

                if (distance(leftX, leftY, tx, ty) > distance(rightX, rightY, tx, ty)) {
                    answer += "R";
                    rightX = tx;
                    rightY = ty;
                } else if (distance(leftX, leftY, tx, ty) == distance(rightX, rightY, tx, ty)) {
                    if (hand.equals("right")) {
                        answer += "R";
                        rightX = tx;
                        rightY = ty;
                    } else {
                        answer += "L";
                        leftX = tx;
                        leftY = ty;
                    }
                } else {
                    answer += "L";
                    leftX = tx;
                    leftY = ty;
                }
            }
        }
        return answer;
    }

    public int[] findIndex(int num) {
        for (int i=0; i<keyPad.length; i++) {
            for (int j=0; j<keyPad[i].length; j++) {
                if (keyPad[i][j] == num)
                    return new int[]{i, j};
            }
        }
        return null;
    }

    public int distance(int x, int y, int tx, int ty) {
        return Math.abs(x - tx) + Math.abs(y - ty);
    }
}