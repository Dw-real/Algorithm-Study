import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a == 0 && b == 0)
                break;
                
            if (b % a == 0) 
                sb.append("factor");
            else if (a % b == 0) 
                sb.append("multiple");
            else
                sb.append("neither");


            sb.append("\n");
        }

        System.out.println(sb);

        scanner.close();
    }
}
