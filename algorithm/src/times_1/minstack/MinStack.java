package times_1.minstack;

import java.util.Stack;

/**
 * @author zhaohongxin
 */
class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (!minStack.isEmpty()) {
            Integer peek = minStack.peek();
            if (peek < x) {
                minStack.push(peek);
            } else {
                minStack.push(x);
            }
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
