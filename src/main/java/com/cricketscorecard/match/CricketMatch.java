package com.cricketscorecard.match;

import com.cricketscorecard.team.CricketTeam;

/**
 * Cricket match impl
 */
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

    /**
     * Constructor : match object can only be created with num of overs and both the cricket teams
     * @param numOvers
     * @param firstTeam
     * @param secondTeam
     */
    public CricketMatch(int numOvers, CricketTeam firstTeam, CricketTeam secondTeam) {
        this.numOvers = numOvers;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    /**
     * Finds  the winner of the match based on the runs scored. Although the return value is not used anywhere, it can serve some purpose for future use and testing.
     * @return
     */
    public String findWinner() {
        int diff = firstTeam.getScore()-secondTeam.getScore();
        if(diff>0) {
            System.out.println("Result: " + firstTeam.getTeamName() + " won the match by " + diff + " runs" );
            return firstTeam.getTeamName();
        }
        else if(diff==0) {
            System.out.println("Result: Match tied" );
            return firstTeam.getTeamName() + ", " + secondTeam.getTeamName();
        }
        else {
            System.out.println("Result: " + secondTeam.getTeamName() + " won the match by " + (secondTeam.getNumPlayers()-secondTeam.getNumWicketsDown()-1) + " wickets" );
            return secondTeam.getTeamName();
        }
    }
}
