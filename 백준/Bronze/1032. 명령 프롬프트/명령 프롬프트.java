import java.io.*;
import java.util.*;

public class Main {
    static String getPattern(ArrayList<String> arr) {
        String pattern = "";
        boolean flag = true;
        int length = arr.get(0).length(); // 파일 이름의 길이는 모두 같음

        for (int i=0; i<length; i++) {
            for (int j=0; j<arr.size() -1; j++) {
                if (arr.get(j).charAt(i) != arr.get(j+1).charAt(i)){
                    flag = false;
                    break;
                }
                else
                    flag = true;
            }

            if (flag)
                pattern += arr.get(0).charAt(i);
            else
                pattern += "?";
        }

        return pattern;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<String> arr = new ArrayList<String>();

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            arr.add(str);
        }

        if (arr.size() != 1)
            bw.write(getPattern(arr) + "\n");
        else
            bw.write(arr.get(0) + "\n");

        br.close();
        bw.close();
    }
}
