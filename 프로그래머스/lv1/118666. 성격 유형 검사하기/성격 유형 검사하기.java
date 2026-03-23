class Solution {
    static int[] type = {0, 0, 0, 0}; // RT, CF, JM, AN
    static int[] score = {3, 2, 1, 0, -1, -2, -3};

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        for (int i=0; i<survey.length; i++) {
            addScore(survey[i], choices[i]);
        }
        if (type[0] >= 0) answer += "R";
        else answer += "T";
        if (type[1] >= 0) answer += "C";
        else answer += "F";
        if (type[2] >= 0) answer += "J";
        else answer += "M";
        if (type[3] >= 0) answer += "A";
        else answer += "N";

        return answer;
    }

    public void addScore(String s, int choice) {
        switch (s) {
            case "RT":
                type[0] += score[choice - 1];
                break;
            case "TR":
                type[0] -= score[choice - 1];
                break;
            case "CF":
                type[1] += score[choice - 1];
                break;
            case "FC":
                type[1] -= score[choice - 1];
                break;
            case "JM":
                type[2] += score[choice - 1];
                break;
            case "MJ":
                type[2] -= score[choice - 1];
                break;
            case "AN":
                type[3] += score[choice - 1];
                break;
            case "NA":
                type[3] -= score[choice - 1];
                break;
        }
    }
}