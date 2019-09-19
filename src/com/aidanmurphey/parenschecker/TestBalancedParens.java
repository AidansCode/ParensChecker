/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aidanmurphey.parenschecker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Aidan Murphey
 */
public class TestBalancedParens {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader br = getBufferedReader();

        try {
            for (int character = br.read(); character != -1; character = br.read()) {
                stringBuilder.append((char) character);
            }
        } catch(Exception e) {}

        try {
            br.close();
        } catch (Exception e) {}

        System.out.println("Testing input from file...");
        System.out.println(ParensChecker.validateString(stringBuilder.toString()));
        System.out.println("Finished parsing file, ending program...");
    }

    public static BufferedReader getBufferedReader() {
        Scanner scanner = new Scanner(System.in);
        String fileName = null;
        BufferedReader br = null;
        boolean openedFile = false;

        do {
            if (fileName != null)
                System.out.println("Unable to open file! Please try again...\n");

            System.out.print("Enter the name of the input file: ");
            fileName = scanner.nextLine();

            try {
                br = new BufferedReader(new FileReader(fileName));
                openedFile = true;
            } catch (Exception e) {}

        } while(!openedFile);

        return br;
    }
    
}
