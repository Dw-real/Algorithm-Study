import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] room = new char[n][n];

        for (int i=0; i<n; i++) {
            String str = br.readLine();

            for (int j=0; j<n; j++) {
                room[i][j] = str.charAt(j);
            }
        }

        int w = 0; // 가로로 누울 수 있는 자리
        int h = 0; // 세로로 누울 수 있는 자리

        for (int i=0; i<n; i++) {
            String str = "";
            for (int j=0; j<n; j++) {
                str += room[i][j];
            }
            String[] s = str.split("X");
            for (String st : s)
                if (st.length() >= 2)
                    w++;
        }

        for (int i=0; i<n; i++) {
            String str = "";
            for (int j=0; j<n; j++) {
                str += room[j][i];
            }
            String[] s = str.split("X");
            for (String st : s)
                if (st.length() >= 2)
                    h++;
        }
        bw.write(w + " " + h + "\n");

        br.close();
        bw.close();
    }
}