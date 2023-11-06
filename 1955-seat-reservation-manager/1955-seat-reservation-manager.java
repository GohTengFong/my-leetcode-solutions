class SeatManager {
    int nextEmpty;
    boolean[] seats;

    public SeatManager(int n) {
        this.nextEmpty = 0;
        this.seats = new boolean[n];
    }
    
    public int reserve() {
        int reserved = nextEmpty + 1;

        this.seats[nextEmpty] = true;

        for (int i = nextEmpty; i < this.seats.length; i++) {
            if (!this.seats[i]) {
                nextEmpty = i;
                break;
            }
        }

        if (nextEmpty + 1 == reserved) nextEmpty = this.seats.length;

        return reserved;
    }
    
    public void unreserve(int seatNumber) {
        seatNumber -= 1;

        if (seatNumber < nextEmpty) nextEmpty = seatNumber;

        this.seats[seatNumber] = false;
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */