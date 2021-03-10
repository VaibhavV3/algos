package com.algorithms.stack;

import java.util.Stack;

public class BalancedParantheses {
    public boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        int sLen = s.length();
        for(int i=0;i<sLen;i++){
            char c = s.charAt(i);
            char expectedChar;
            if(c==')')
                expectedChar = '(';
            else if(c=='}')
                expectedChar = '{';
            else{
                stack.push(c);
                continue;
            }

            if(stack.empty())
                return false;

            if(stack.peek()!=expectedChar)
                return false;
            else
                stack.pop();
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        BalancedParantheses balancedParantheses = new BalancedParantheses();
        System.out.println(balancedParantheses.isBalanced("{}()"));
        System.out.println(balancedParantheses.isBalanced("{()}"));
        System.out.println(balancedParantheses.isBalanced("{}("));
        System.out.println(balancedParantheses.isBalanced("({()})"));
        System.out.println(balancedParantheses.isBalanced("({)}"));
        System.out.println(balancedParantheses.isBalanced("(("));
        System.out.println(balancedParantheses.isBalanced("}{"));
    }
}
