class MyQueue {

    private Stack mainStack;
    private Stack tempStack;
    private int firstElement;

    public MyQueue() {
        this.mainStack = new Stack();
        this.tempStack = new Stack();
    }
    
    public void push(int x) {
        if (this.mainStack.empty()) {
            this.firstElement = x;
        }

        this.mainStack.push(x);
    }
    
    public int pop() {
        while(!mainStack.empty()) {
            this.tempStack.push(mainStack.pop());
        }

        Integer ans = (Integer) this.tempStack.pop();

        while (!tempStack.empty()) {
            Integer element = (Integer) tempStack.pop();

            this.push(element);
        }

        return ans;
    }
    
    public int peek() {
        return this.firstElement;
    }
    
    public boolean empty() {
        return this.mainStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */