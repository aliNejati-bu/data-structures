package com.ali.stacks.applications;

import com.ali.stacks.abstraction.IStack;

public class StackApplications {
    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == ')' || ch == '(';
    }

    static int getOperatorValue(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }

    static boolean pushable(Character inStack, Character newOperator) {
        if (inStack == null){
            return true;
        }
        if (newOperator == '^' || newOperator == '(')
            return true;
        int newValue = getOperatorValue(newOperator);
        int inStackValue = getOperatorValue(inStack);
        return newValue > inStackValue;
    }

    public static String infixToPostfix(String infixExpression, IStack<Character> stack) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < infixExpression.length(); i++) {
            char currChar = infixExpression.charAt(i);
            if (currChar == ')') {
                char c = stack.pop();
                while (c != '(') {
                    result.append(c);
                    c = stack.pop();
                }
            }
            else if (isOperator(currChar)) {
                Character c = stack.pop();
                while (!pushable(c, currChar)) {
                    result.append(c);
                    c = stack.pop();
                }
                if (c != null){
                    stack.push(c);
                }
                stack.push(currChar);
            }
            else {
                result.append(currChar);
            }
        }
        if (!stack.isEmpty()){
            Character c = stack.pop();
            while (c!=null){
                result.append(c);
                c = stack.pop();
            }
        }
        return result.toString();
    }
}
