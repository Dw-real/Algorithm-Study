import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        int n = scanner.nextInt();

        boolean array[][] = new boolean[100][100];

        for (int i=0; i<n; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            for (int j=x; j<x+10; j++) {
                for (int k=y; k<y+10; k++) {
                    if (array[j][k] != true) {
                        array[j][k] = true;
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

        scanner.close();
    }
}
