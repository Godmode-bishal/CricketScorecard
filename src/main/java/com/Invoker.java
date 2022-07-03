package com;

import com.cricketscorecard.processor.CricketInputProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Invoker {
    public static void main(String[] args) {
        URL url = Invoker.class.getResource("..//input1.txt");
        File file = new File(url.getPath());
        //read file into stream, try-with-resources
        CricketInputProcessor processor = new CricketInputProcessor();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            processor.process(br);
        }
        catch(NullPointerException e) {
            System.out.println("Invalid input. Check the input file input.txt");
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
