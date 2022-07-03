package com;

import com.cricketscorecard.processor.CricketInputProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class Invoker {
    public static void main(String[] args) {
        URL url = Invoker.class.getResource("..//input.txt");
        File file = new File(url.getPath());
        //read file into stream, try-with-resources
        CricketInputProcessor processor = new CricketInputProcessor();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            processor.process(br);
        }
        catch(NullPointerException e) {
            System.out.println("Invalid input. Check the input file input.txt or did you not initialize the team players ?");
            e.printStackTrace();
        }
        catch(NumberFormatException e) {
            System.out.println("Invalid input. Check the input file input.txt. Did you enter a non-number when a number is expected ?");
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
