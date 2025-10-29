import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if (sb.length() >= bomb.length()) {
                boolean containBomb = true;

                for (int j = 0; j < bomb.length(); j++) {
                    if (sb.charAt(sb.length() - bomb.length() + j) != bomb.charAt(j)) {
                        containBomb = false;
                        break;
                    }
                }

                // 폭발 문자열을 가지고 있다면
                if (containBomb) {
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            bw.write("FRULA\n");
        } else {
            bw.write(sb + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
