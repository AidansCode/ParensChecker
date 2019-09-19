/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aidanmurphey.parenschecker;

/**
 *
 * @author tcim210
 */
public class ParensChecker {

    public static String validateString(String str) {
        ArrayStack<Character> stack = new ArrayStack<>();
        char last = ' ';

        try {
            for (char c : str.toCharArray()) {
                if (isRelevantCharacter(c)) {
                    last = c;
                    if (isOpenChar(c))
                        stack.push(c);
                    else { //is close char
                        if (stack.peek() == getCorrespondingChar(c))
                            stack.pop();
                        else
                            return "Invalid expression! Braces are out of order.";
                    }
                }
            }
        } catch(Exception e) {
            return "Invalid expression! Missing left brace: " + getCorrespondingChar(last);
        }

        if (!stack.isEmpty())
            return "Invalid expression! Missing right brace: " + getCorrespondingChar(stack.peek());
        return "Valid expression!";
    }

    private static boolean isRelevantCharacter(char c) {
        char[] chars = {'{', '}', '[', ']', '(', ')'};

        for (char relevantChar : chars)
            if (c == relevantChar)
                return true;
        return false;
    }

    private static boolean isOpenChar(char c) {
        char[] chars = {'{', '[', '('};

        for (char openChar : chars)
            if (c == openChar)
                return true;
        return false;
    }

    private static char getCorrespondingChar(char c) {
        switch(c) {
            case '{':
                return '}';
            case '}':
                return '{';
            case '[':
                return ']';
            case ']':
                return '[';
            case '(':
                return ')';
            case ')':
                return '(';
            default:
                return ' ';
        }
    }
    
}
