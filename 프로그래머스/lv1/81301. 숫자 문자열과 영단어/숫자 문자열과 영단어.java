class Solution {
    public int solution(String s) {
        int answer = 0;
        answer = getAnswer(s);
        return answer;
    }
    
    public int getAnswer(String s) {
        String[] word = {"zero", "one", "two", "three", "four", "five", "six"
            , "seven", "eight", "nine"};
        for (int i=0; i<word.length; i++) {
            if (s.contains(word[i]))
                s = s.replaceAll(word[i], i+"");
        }
        int num = Integer.parseInt(s);
        return num;
    }
}