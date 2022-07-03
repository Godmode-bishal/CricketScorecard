package com.scorecard.team;

import com.cricketscorecard.player.CricketPlayer;
import com.cricketscorecard.team.CricketTeam;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestCricketTeam {
    CricketTeam cricketTeam = new CricketTeam(2, "Team");
    @Before
    public void setup() {
        CricketPlayer[] cricketPlayers = cricketTeam.getCricketPlayers();
        cricketPlayers[0] = new CricketPlayer("A"+0);
        cricketPlayers[0].setRunsScored(10);
        cricketPlayers[0].setBallsFaced(2);
        cricketPlayers[1] = new CricketPlayer("A"+1);
        cricketPlayers[1].setRunsScored(12);
        cricketPlayers[1].setBallsFaced(3);
        cricketPlayers[1].setIsOut(true);
    }

    @Test
    public void getScoreTest() {
        Assert.assertEquals(cricketTeam.getScore(), 22);
    }

    @Test
    public void getWicketsDownTest() {
        Assert.assertEquals(cricketTeam.getNumWicketsDown(),1);
    }
}
