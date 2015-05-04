package ru.kpfu.itis.group403.khusaenov.BracketsCheckerStack;

import java.util.Stack;

public class Checker {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String openBrackets = "([<{";
        String closeBrackets = ")]>}";
        String str = "<[2 + 5]>(){}";

        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (openBrackets.contains(a + ""))
                stack.push(a);
            else if (closeBrackets.contains(a + "")) {
                if (stack.isEmpty()) {
                    System.out.println("error");
                    return;
                } else {
                    int k;
                    if (stack.peek() == '(')
                        k = -1;
                    else
                        k = -2;
                    if ((stack.pop() - a) != k) {
                        System.out.println("Несоответствие скобок.");
                        return;
                    }
                }
            }
        }
        if (!stack.isEmpty())
            System.out.println("Скобка не закрыта.");
    }
}
