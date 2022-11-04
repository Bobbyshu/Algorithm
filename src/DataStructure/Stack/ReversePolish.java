package DataStructure.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
/*
switch case should break, otherwise JVM will continue to scan another branch
 */
public class ReversePolish {
    public int evalRPN(String[] tokens) {
        int op1, op2;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    op2 = stack.pollLast();
                    op1 = stack.pollLast();
                    stack.addLast(op1 + op2);
                    break;
                case "-":
                    op2 = stack.pollLast();
                    op1 = stack.pollLast();
                    stack.addLast(op1 - op2);
                    break;
                case "*":
                    op2 = stack.pollLast();
                    op1 = stack.pollLast();
                    stack.addLast(op1 * op2);
                    break;
                case "/":
                    op2 = stack.pollLast();
                    op1 = stack.pollLast();
                    stack.addLast(op1 / op2);
                    break;
                default:
                    stack.addLast(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pollLast();
    }
}
