/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aidanmurphey.parenschecker;

import java.util.Scanner;

/**
 *
 * @author Aidan Murphey
 */
public class TestBalancedParens {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Enter an infix expression (\";\" to stop): ");
            input = scanner.nextLine();

            if (!input.equals(";")) {
                System.out.println(ParensChecker.validateString(input));
            }
        } while(!input.equals(";"));

        System.out.println("Closing program...");
    }
    
}
