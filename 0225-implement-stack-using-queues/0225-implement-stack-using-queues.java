class MyStack {
    private LinkedList<Integer> q;

    public MyStack() {
        this.q = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        this.q.add(x);
    }
    
    public int pop() {
        return this.q.removeLast();
    }
    
    public int top() {
        return this.q.getLast();

    }
    
    public boolean empty() {
        return this.q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */