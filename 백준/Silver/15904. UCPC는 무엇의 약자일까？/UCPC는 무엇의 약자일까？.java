import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();

        String[] st = str.split("");
        int i = 0;

        for (String s: st) {
            if (i == 0 && s.equals("U"))
                i++;
            if ((i == 1 || i == 3) && s.equals("C"))
                i++;
            if (i == 2 && s.equals("P"))
                i++;
        }

        if (i == 4)
            bw.write("I love UCPC\n");
        else
            bw.write("I hate UCPC\n");

        br.close();
        bw.close();
    }
}
