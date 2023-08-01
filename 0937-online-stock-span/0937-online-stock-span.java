class StockSpanner {

    LinkedList<int[]> monoStack; // [price, span]

    public StockSpanner() {
        this.monoStack = new LinkedList<int[]>();
    }
    
    public int next(int price) {
        int span = 1;

        while (!this.monoStack.isEmpty() && this.monoStack.peek()[0] <= price) {
            span += this.monoStack.pop()[1];
        }
        
        this.monoStack.push(new int[] {price, span});

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */