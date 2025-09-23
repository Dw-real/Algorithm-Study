import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Double> score = Map.of(
            "A+", 4.5,
            "A0", 4.0,
            "B+", 3.5,
            "B0", 3.0,
            "C+", 2.5,
            "C0", 2.0,
            "D+", 1.5,
            "D0", 1.0,
            "F", 0.0
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double sum = 0.0;
        double creditSum = 0.0; // 평점에 포함되는 과목의 학점의 합

        for (int i = 0; i < 20; i++) {
            String s = br.readLine();
            String[] str = s.split(" ");
            double credit = Double.parseDouble(str[1]);
            String grade = str[2];

            if (grade.equals("P")) continue;

            sum += (score.get(grade) * credit);
            creditSum += credit;
        }

        bw.write(sum / creditSum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
