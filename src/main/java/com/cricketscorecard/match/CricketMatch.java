package com.cricketscorecard.match;

import com.cricketscorecard.team.CricketTeam;

public class CricketMatch implements Match {
    private CricketTeam firstTeam;
    private CricketTeam secondTeam;
    private int numOvers;

    public CricketTeam getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(CricketTeam firstTeam) {
        this.firstTeam = firstTeam;
    }

    public CricketTeam getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(CricketTeam secondTeam) {
        this.secondTeam = secondTeam;
    }

    public int getNumOvers() {
        return numOvers;
    }

    public void setNumOvers(int numOvers) {
        this.numOvers = numOvers;
    }

    public CricketMatch(int numOvers, CricketTeam firstTeam, CricketTeam secondTeam) {
        this.numOvers = numOvers;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    //TODO implemenet later
    public void findWinner() {
        int diff = firstTeam.getScore()-secondTeam.getScore();
        if(diff>0) {
            System.out.println("Result: " + firstTeam.getTeamName() + " won the match by " + diff + " runs" );
        }
        else if(diff==0) {
            System.out.println("Result: Match tied" );
        }
        else {
            System.out.println("Result: " + secondTeam.getTeamName() + " won the match by " + -diff + " runs" );
        }
    }
}
