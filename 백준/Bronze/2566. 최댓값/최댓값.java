import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = 0;
        int maxR = 0;
        int maxC = 0;

        int array[][] = new int[9][9];

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    maxR = i;
                    maxC = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((maxR + 1) + " " + (maxC + 1));

        scanner.close();
    }
}
