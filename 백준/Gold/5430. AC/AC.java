import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수
        for (int i = 0; i < t; i++) {
            String p = br.readLine(); // 수행할 함수
            int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수의 개수

            String arr = br.readLine(); // 배열에 들어있는 정수 집합
            String numList = arr.substring(1, arr.length() - 1);
            ArrayList<Integer> list = new ArrayList<>();

            boolean valid = true; // 제거 가능 여부
            boolean dir = true; // R 커맨드 입력 시 방향 (true 정방향, false 역방향)

            if (!numList.isEmpty()) {
                String[] nums = numList.split(",");

                for (String num : nums) {
                    list.add(Integer.parseInt(num));
                }
            }

            for (int j = 0; j < p.length(); j++) {
                char comm = p.charAt(j);

                if (comm == 'R') {
                    dir = !dir;
                } else {
                    if (list.isEmpty()) {
                        valid = false;
                        break;
                    } else {
                        if (dir) {
                            list.remove(0);
                        } else {
                            list.remove(list.size() - 1);
                        }
                    }
                }
            }

            if (!valid) {
                bw.write("error\n");
            } else {
                if (list.isEmpty()) {
                    bw.write("[]\n");
                } else {
                    bw.write("[");
                    if (dir) {
                        for (int j = 0; j < list.size() - 1; j++) {
                            bw.write(list.get(j) + ",");
                        }
                        bw.write(list.get(list.size() - 1) + "]\n");
                    } else {
                        for (int j = list.size() - 1; j > 0; j--) {
                            bw.write(list.get(j) + ",");
                        }
                        bw.write(list.get(0) + "]\n");
                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}