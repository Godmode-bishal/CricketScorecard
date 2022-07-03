package com.cricketscorecard.player;

/**
 * Sportplayer can be extended by players of different sport
 */
public class SportPlayer {
    String name;
    SportPlayer(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
