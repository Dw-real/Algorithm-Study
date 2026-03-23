import java.util.*;

class Solution {
    static int[][] copyPark;
    static int max = 0;
    static int ans = -1;

    public int solution(int[] mats, String[][] park) {
        copyPark = new int[park.length][park[0].length];
        for (int i=0; i<park.length; i++) {
            for (int j=0; j<park[i].length; j++) {
                if (park[i][j].equals("-1"))
                    copyPark[i][j] = 1;
                else
                    copyPark[i][j] = 0;
            }
        }
        getMaxArea(copyPark);

        Arrays.sort(mats);
        for (int i=0; i<mats.length; i++) {
            if (mats[i] <= max)
                ans = mats[i];
            else
                break;
        }

        return ans;
    }

    public void getMaxArea(int[][] copyPark) {
        for (int i=1; i<copyPark.length; i++) {
            for (int j=1; j<copyPark[i].length; j++) {
                if (copyPark[i][j] > 0) {
                    copyPark[i][j] = Math.min(copyPark[i - 1][j - 1], Math.min(copyPark[i][j - 1], copyPark[i - 1][j])) + 1;
                    if (copyPark[i][j] > max)
                        max = copyPark[i][j];
                }

            }
        }
    }
}