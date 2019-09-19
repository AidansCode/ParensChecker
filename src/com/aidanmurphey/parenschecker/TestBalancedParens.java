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

        br.lines().forEach(line -> {
            System.out.println("Testing expression: \"" + line + "\"");
            System.out.println(ParensChecker.validateString(line));
            System.out.println("\n----------------------------------\n");
        });

        try {
            br.close();
        } catch (Exception e) {}

        System.out.println("Reached end of file, ending program...");
    }
    
}
