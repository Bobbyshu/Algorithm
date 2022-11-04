package DataStructure.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc1106 {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : expression.toCharArray()) {
            if (c == ',')
                continue;
            // 放进栈里面去，标记嵌套的起始位置
            if (c != ')') {
                stack.addLast(c);
            } else {
                Deque<Character> buffer = new ArrayDeque<>();
                // 把括号中间的字符都放到新栈中去
                while (stack.peekLast() != '(') {
                    buffer.addLast(stack.pollLast());
                }
                // 去掉 ( 字符
                stack.pollLast();
                char ret = process(buffer, stack.pollLast());
                stack.addLast(ret);
            }
        }
        return stack.peekLast() == 't';
    }

    private char process(Deque<Character> buffer, char operation) {
        if (operation == '!')
            return buffer.pollLast() == 't' ? 'f' : 't';

        if (operation == '&') {
            while (!buffer.isEmpty()) {
                if (buffer.pollLast() == 'f')
                    return 'f';
            }
            return 't';
        } else {
            while (!buffer.isEmpty()) {
                if (buffer.pollLast() == 't')
                    return 't';
            }
            return 'f';
        }
    }
}
