package com.cricketscorecard.processor;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Input parser after reading from file for any sport. Different kind of parser can be made for various sport
 */
abstract class SportsInputProcessor {
    abstract void process(BufferedReader br) throws IOException;
}
