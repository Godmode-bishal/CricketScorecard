package com.cricketscorecard.processor;

import java.io.BufferedReader;
import java.io.IOException;

abstract class SportsInputProcessor {
    abstract void process(BufferedReader br) throws IOException;
}
