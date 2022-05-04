package com.company;

public class Result {

    private String segment;
    private String description;
    private int noise;
    private int junk;
    private float matchingPercentage;
    private int rowStart;
    private int rowEnd;
    private int columnStart;
    private int columnEnd;

    public Result(String segment, float matchingPercentage, int rowStart, int rowEnd, int columnStart, int columnEnd, int noise, int junk) {
        this.segment = segment;
        this.matchingPercentage = matchingPercentage;
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
        this.columnStart = columnStart;
        this.columnEnd = columnEnd;
        this.noise = noise;
        this.junk = junk;
    }

    public String printResult() {
        String outputString = new String("Potential match found at: " + segment + " Matching Percentage is : " + matchingPercentage + " Row start: " + rowStart + " Row end: " + rowEnd + " Column start: " + columnStart + " Column end: " + columnEnd + " noise: " + noise + " junk: " + junk);
        return outputString;
    }
}
