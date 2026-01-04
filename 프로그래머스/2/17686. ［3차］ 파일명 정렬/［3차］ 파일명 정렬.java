import java.util.*;

class File implements Comparable<File> {
    String head;
    int number;
    int idx;

    public File(String name, int idx) {
        int i = 0;

        while (i < name.length() && !Character.isDigit(name.charAt(i)))
            i++;
        this.head = name.substring(0, i);

        int j = i;

        while (j < name.length() && Character.isDigit(name.charAt(j)))
            j++;

        this.number = Integer.parseInt(name.substring(i, j));

        this.idx = idx;
    }

    @Override
    public int compareTo(File f) {
        if (this.head.toUpperCase().compareTo(f.head.toUpperCase()) != 0)
            return this.head.toUpperCase().compareTo(f.head.toUpperCase());
        if (this.number - f.number != 0)
            return this.number - f.number;

        return this.idx - f.idx;
    }
}

class Solution {
    public String[] solution(String[] files) {
        ArrayList<File> list = new ArrayList<>();

        for (int i=0; i<files.length; i++) {
            list.add(new File(files[i], i));
        }

        Collections.sort(list);

        String[] answer = new String[files.length];
        for (int i=0; i<list.size(); i++) {
            answer[i] = files[list.get(i).idx];
        }

        return answer;
    }
}