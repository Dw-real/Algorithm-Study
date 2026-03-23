class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = 0;
        m = replaceSound(m);

        for (String s : musicinfos) {
            String[] info = s.split(",");
            String start = info[0];
            String end = info[1];
            String name = info[2];
            String rhythm = replaceSound(info[3]);

            int time = getTime(start, end);
            if (validMusic(m, time, rhythm) && time > maxTime) {
                answer = name;
                maxTime = time;
            }
        }

        return answer;
    }

    public int getTime(String start, String end) {
        String[] time1 = start.split(":");
        String[] time2 = end.split(":");

        int hour1 = Integer.parseInt(time1[0]);
        int hour2 = Integer.parseInt(time2[0]);
        int minute1 = Integer.parseInt(time1[1]);
        int minute2 = Integer.parseInt(time2[1]);

        if (minute2 >= minute1) {
            return (hour2 - hour1) * 60 + minute2 - minute1;
        } else {
            return (hour2 - hour1 - 1) * 60 + (60 + minute2 - minute1);
        }
    }

    public boolean validMusic(String m, int time, String rhythm) {
        if (time < rhythm.length()) {
            rhythm = rhythm.substring(0, time + 1);
        } else {
            if (time % rhythm.length() == 0) {
                rhythm = rhythm.repeat(time / rhythm.length());
            } else {
                rhythm = rhythm.repeat(time / rhythm.length() + 1).substring(0, time + 1);
            }

        }
        return rhythm.contains(m);
    }
    
    public String replaceSound(String m) {
        m = m.replace("C#", "c");
        m = m.replace("D#", "d");
        m = m.replace("E#", "e");
        m = m.replace("G#", "g");
        m = m.replace("A#", "a");
        m = m.replace("B#", "b");
        m = m.replace("F#", "f");

        return m;
    }
}