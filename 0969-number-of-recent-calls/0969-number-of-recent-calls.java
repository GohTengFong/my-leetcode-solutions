class RecentCounter {
    private LinkedList<Integer> q;
    private int count;

    public RecentCounter() {
        count = 0;
        q = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        while (!q.isEmpty() && q.peek() + 3000 < t) {
            q.pop();
            count--;
        }

        q.add(t);
        count++;
        
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */