import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        int time = scanner.nextInt();
        
        if (minute + time < 60) {
            System.out.println (hour + " " + (minute+time));
        }
        else {
            int totalMinute = minute + time;
            int t = totalMinute / 60;
            int m = totalMinute % 60;
            
            if (hour + t >= 24)
                System.out.println((hour+t-24) + " " + m);
            else
                System.out.println((hour+t) + " " + m);
        }
        scanner.close();
    }
}