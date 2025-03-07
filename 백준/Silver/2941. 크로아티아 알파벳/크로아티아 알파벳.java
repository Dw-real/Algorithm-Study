import java.io.*;
import java.util.*;

public class Main {
    static int croatia(String str) {
        String tmp = str.replace("c=", "1")
                        .replace("c-", "2")
                        .replace("dz=", "3")
                        .replace("d-", "4")
                        .replace("lj", "5")
                        .replace("nj", "6")
                        .replace("s=", "7")
                        .replace("z=", "8");
                        
        return tmp.length();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        bw.write(croatia(str) + "" + "\n");

        br.close();
        bw.close();
    }
}
