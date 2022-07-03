package com.cricketscorecard.team;

import com.cricketscorecard.player.CricketPlayer;

public class CricketTeam extends SportsTeam {
    private int numPlayers;
    private CricketPlayer[] cricketPlayers;
    private int extras;

    public void incrementExtras() {
        extras++;
    }

    //if looping through the number of players isn't acceptable, then we can maintain a wicketDown variable. But since the number of players is constant , looping should be okay. Cricket rules aren't changing in foreseeable future.
    public int getNumWicketsDown() {
        int wicketsDown = 0;
        for(int i = 0; i<numPlayers; i++) {
            if(cricketPlayers[i].getIsOut()) {
                wicketsDown++;
            }
        }
        return wicketsDown;
    }

    public int getScore() {
        int totalScore = 0;
        for(int i = 0; i<numPlayers; i++) {
            totalScore += cricketPlayers[i].getRunsScored();
        }
        return totalScore + extras;
    }

    public int getExtras(){
        return extras;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public CricketPlayer[] getCricketPlayers() {
        return cricketPlayers;
    }

    public void setCricketPlayers(CricketPlayer[] cricketPlayers) {
        this.cricketPlayers = cricketPlayers;
    }

    public CricketTeam(int numPlayers, String teamName) {
        super(teamName);
        this.cricketPlayers =  new CricketPlayer[numPlayers];
        this.numPlayers = numPlayers;
    }

}
