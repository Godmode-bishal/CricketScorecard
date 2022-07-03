package com.cricketscorecard.processor;

import com.cricketscorecard.match.CricketMatch;
import com.cricketscorecard.team.CricketTeam;
import com.cricketscorecard.player.CricketPlayer;

import java.io.BufferedReader;
import java.io.IOException;

public class CricketInputProcessor extends SportsInputProcessor {
    private int numPlayers ;
    private int numOvers ;

    public void process(BufferedReader br) throws IOException {
        //Read 1st line : Num of players
        numPlayers = Integer.parseInt(br.readLine());

        //There  are always 2 teams in cricket.
        CricketTeam firstTeam = new CricketTeam(numPlayers, "Team 1");
        CricketTeam secondTeam = new CricketTeam(numPlayers, "Team 2");
        CricketPlayer[] firstTeamCricketPlayers = firstTeam.getCricketPlayers();
        CricketPlayer[] secondTeamCricketPlayers = secondTeam.getCricketPlayers();

        //Read 2nd line : Number of overs
        numOvers = Integer.parseInt(br.readLine());
        for(int i = 0; i<numPlayers; i++) {
            firstTeamCricketPlayers[i] = new CricketPlayer(br.readLine());
        }

        //Striker and non-striker according to batting order
        CricketPlayer striker = firstTeamCricketPlayers[0];
        CricketPlayer nonStriker = firstTeamCricketPlayers[1];

        getScoreAndDisplayResult(br, striker, nonStriker, firstTeamCricketPlayers, firstTeam);

        //2nd team
        for(int i = 0; i<numPlayers; i++) {
            secondTeamCricketPlayers[i] = new CricketPlayer(br.readLine());
        }
        striker = secondTeamCricketPlayers[0];
        nonStriker = secondTeamCricketPlayers[1];
        getScoreAndDisplayResult(br, striker, nonStriker, secondTeamCricketPlayers, secondTeam);


        CricketMatch match = new CricketMatch(numOvers, firstTeam, secondTeam);
        match.findWinner();
    }

    private void getScoreAndDisplayResult(BufferedReader br, CricketPlayer striker, CricketPlayer nonStriker, CricketPlayer[] teamPlayers, CricketTeam team) throws IOException {
        CricketPlayer placeHolder = null;
        int numPlayersOut  = 0;
        int numBallsForIncompleteOver = 0;
        for(int i = 0; i<numOvers; i++) {
            for(int j = 0; j<6; ) {
                String line = br.readLine();
                switch (line) {
                    case "W":
                    {
                        striker.incrementBallsFaced();
                        striker.setIsOut(true);
                        numPlayersOut++;
                        if(numPlayersOut+2<=numPlayers) {
                            striker = teamPlayers[numPlayersOut+1];
                        }
                        else {
                            //TODO innigns over
                            numBallsForIncompleteOver = j+1;
                            display(team, teamPlayers, i, numBallsForIncompleteOver);
                            return;
                        }
                        j++;
                        break;
                    }
                    case "N":
                    case "Wd": {
                        team.incrementExtras();
                        break;
                    }
                    default:
                    {
                        striker.increaseRunsScored(Integer.parseInt(line));
                        striker.incrementBallsFaced();
                        if(Integer.parseInt(line)%2!=0) {
                            placeHolder = striker;
                            striker = nonStriker;
                            nonStriker = placeHolder;
                        }
                        if(Integer.parseInt(line)==4) {
                            striker.incrementNumOfFoursHit();
                        }
                        else if(Integer.parseInt(line)==6) {
                            striker.incrementNumOfSixesHit();
                        }
                        j++;
                    }
                }
            }
            placeHolder = striker;
            striker = nonStriker;
            nonStriker = placeHolder;
            display(team, teamPlayers, i, numBallsForIncompleteOver);
        }
    }

    private void display(CricketTeam team, CricketPlayer[] teamPlayers, int over, int numBallsForIncompleteOver) {
        System.out.println("\nScorecard for " + team.getTeamName() + "\nPlayer Name\t\tScore\t\t4s\t6s\tBalls");
        for(int j = 0; j<numPlayers; j++) {
            System.out.print(teamPlayers[j].getName() +
                    "\t\t\t\t" + teamPlayers[j].getRunsScored() +
                    "\t\t\t" + teamPlayers[j].getNumOfFoursHit() +
                    "\t" + teamPlayers[j].getNumOfSixesHit() +
                    "\t" + teamPlayers[j].getBallsFaced() + "\n");
        }
        System.out.println("Total: " + team.getScore() + "/" + team.getNumWicketsDown());
        over = numBallsForIncompleteOver!=0?over-1:over;
        System.out.print("Overs:" +(over+1) + "." + numBallsForIncompleteOver + "\n");
    }
}
