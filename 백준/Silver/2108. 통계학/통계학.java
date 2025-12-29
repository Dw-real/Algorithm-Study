import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeMap<Integer, Integer> count = new TreeMap<>();
        ArrayList<Integer> arr = new ArrayList<>();

        double sum = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            count.put(num, count.getOrDefault(num, 0) + 1);
            arr.add(num);
        }

        Collections.sort(arr);

        int max = 0;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (max < entry.getValue()) {
                maxCount = 1;
                max = entry.getValue();
            } else if (max == entry.getValue()) {
                maxCount++;
            }
        }

        int order = 1;
        int mostFrequency = 0;

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == max) {
                if (maxCount == 1) {
                    mostFrequency = entry.getKey();
                    break;
                } else {
                    if (order == 2) {
                        mostFrequency = entry.getKey();
                        break;
                    } else {
                        order++;
                    }
                }
            }
        }

        // 산술 평균
        bw.write((int) Math.round(sum / n) + "\n");

        // 중앙 값
        bw.write(arr.get(n / 2) + "\n");

        // 최빈 값
        bw.write(mostFrequency + "\n");

        // 범위
        bw.write(arr.get(n - 1) - arr.get(0) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
