import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        while (true) {
            String str = br.readLine();

            if (str == null || str.isEmpty())
                break;

            long num = Long.parseLong(str);
            long oneNum = 0;
            int count = 1;

            while (true) {
                oneNum = oneNum * 10 + 1;
                oneNum %= num;

                if (oneNum == 0) {
                    bw.write(count + "" + "\n");
                    break;
                }
                count++;
            }
        }   
        
        bw.flush();
        br.close();
        bw.close();
    }
}
