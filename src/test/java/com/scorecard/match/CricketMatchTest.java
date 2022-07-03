package com.scorecard.match;

import com.cricketscorecard.match.CricketMatch;
import com.cricketscorecard.player.CricketPlayer;
import com.cricketscorecard.team.CricketTeam;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CricketMatchTest {
    CricketTeam firstCricketTeam = new CricketTeam(1, "Team1");
    CricketTeam secondCricketTeam = new CricketTeam(1, "Team2");
    CricketMatch cricketMatch = new CricketMatch(2,firstCricketTeam,secondCricketTeam);

    @Test(expected = NullPointerException.class)
    public void accessTeamWithoutInitialization() {
        //Bit of a useless test
        CricketPlayer[] cricketPlayers = firstCricketTeam.getCricketPlayers();
        cricketPlayers[0].increaseRunsScored(5);
    }

    @Test
    public void findWinnerTest() {
        CricketPlayer[] firstTeamcricketPlayers = firstCricketTeam.getCricketPlayers();
        CricketPlayer[] secondTeamcricketPlayers = secondCricketTeam.getCricketPlayers();
        firstTeamcricketPlayers[0] = new CricketPlayer("A");
        firstTeamcricketPlayers[0].setRunsScored(15);
        secondTeamcricketPlayers[0] = new CricketPlayer("B");
        secondTeamcricketPlayers[0].setRunsScored(10);
        Assert.assertEquals("Team1",cricketMatch.findWinner());
        firstTeamcricketPlayers[0].setRunsScored(10);
        secondTeamcricketPlayers[0].setRunsScored(10);
        Assert.assertEquals("Team1, Team2",cricketMatch.findWinner());
        firstTeamcricketPlayers[0].setRunsScored(10);
        secondTeamcricketPlayers[0].setRunsScored(20);
        Assert.assertEquals("Team2",cricketMatch.findWinner());

    }
}
