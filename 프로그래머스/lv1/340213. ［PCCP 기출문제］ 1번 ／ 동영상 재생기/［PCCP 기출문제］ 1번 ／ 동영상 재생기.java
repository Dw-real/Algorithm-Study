class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int posSecond = getSecond(pos);
        int startSecond = getSecond(op_start);
        int endSecond = getSecond(op_end);
        int videoSecond = getSecond(video_len);  

        if (posSecond >= startSecond && posSecond <= endSecond)
            posSecond = endSecond;

        for (int i=0; i<commands.length; i++) {
            if (commands[i].equals("next")) {
                if (posSecond + 10 <= videoSecond && !(posSecond + 10 >= startSecond && posSecond + 10 <= endSecond))
                    posSecond += 10;
                else if (posSecond + 10 >= startSecond && posSecond + 10 <= endSecond)
                    posSecond = endSecond;
                else if (posSecond + 10 > videoSecond)
                    posSecond = videoSecond;
            }
            else if (commands[i].equals("prev")) {
                if (posSecond - 10 >= 0 && !(posSecond - 10 >= startSecond && posSecond - 10 <= endSecond))
                    posSecond -= 10;
                else if (posSecond - 10 >= startSecond && posSecond - 10 <= endSecond || (posSecond - 10 < 0 && startSecond == 0))
                    posSecond = endSecond;
                else if (posSecond - 10 < 0)
                    posSecond = 0;
            }
        }
        int minute = posSecond / 60;
        int second = posSecond % 60;
        String answer = String.format("%02d:%02d", minute, second);

        return answer;
    }

    public int getSecond(String str) {
        String[] time = str.split(":");
        int seconds = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        return seconds;
    }

}