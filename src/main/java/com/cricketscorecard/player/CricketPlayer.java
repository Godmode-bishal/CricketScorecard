package com.cricketscorecard.player;

public class CricketPlayer extends SportPlayer{
    private int runsScored;
    private int wicketsTaken;
    private int ballsFaced;
    private int numOfFoursHit;
    private int numOfSixesHit;
    private int numOfExtrasConceded;
    private boolean isOut;

    public CricketPlayer(String name) {
        super(name);
    }

    public void setIsOut(boolean isOut) {
        this.isOut = isOut;
    }

    public boolean getIsOut() {
        return isOut;
    }

    public void incrementBallsFaced() {
        ballsFaced++;
    }

    public void increaseRunsScored(int runs) {
        runsScored += runs;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public int getNumOfFoursHit() {
        return numOfFoursHit;
    }

    public void incrementNumOfFoursHit() {
        numOfFoursHit++;
    }

    public int getNumOfSixesHit() {
        return numOfSixesHit;
    }

    public void incrementNumOfSixesHit() {
        numOfSixesHit++;
    }

    public int getNumOfExtrasConceded() {
        return numOfExtrasConceded;
    }

    public void setNumOfExtrasConceded(int numOfExtrasConceded) {
        this.numOfExtrasConceded = numOfExtrasConceded;
    }


}
