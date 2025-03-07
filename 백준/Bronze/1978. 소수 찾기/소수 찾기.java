import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int count = 0;
       

        for (int i=0; i<n; i++) {
            int num = scanner.nextInt();
            boolean flag = true;

            if (num != 1) {
                for (int j=2; j<num; j++) {
                    if (num % j == 0){
                        flag = false;
                        break;
                    }
                }
            }
            else {
                count--;
            }
            if (flag == true)
                count++;
        }

        System.out.println(count);

        scanner.close();
    }
}
