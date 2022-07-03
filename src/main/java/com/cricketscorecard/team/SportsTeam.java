package com.cricketscorecard.team;

/**
 * Can be implemented for multiple sport
 */
public class SportsTeam {
    String teamName;
    SportsTeam(String teamName) {
        this.teamName = teamName;
    }
    public String getTeamName() {
        return teamName;
    }
}
