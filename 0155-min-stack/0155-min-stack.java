class MinStack {

    private Stack<Pair<Integer, Integer>> stack;

    public MinStack() {
        stack = new Stack<Pair<Integer, Integer>>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair<Integer, Integer>(val, val));
        } else {
            int min = Math.min(stack.peek().getValue(), val);
            stack.push(new Pair<Integer, Integer>(val, min));
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek().getKey();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */