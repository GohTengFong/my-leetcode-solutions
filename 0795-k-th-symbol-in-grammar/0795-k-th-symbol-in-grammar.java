class Solution {
    private int flipBit(int bit) {
        return (bit == 0) ? 1 : 0;
    }

    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;

        if (k % 2 == 1) return kthGrammar(n - 1, (k + 1) / 2);
        else return flipBit(kthGrammar(n - 1, k / 2));
    }
}

/*

Row1	        			  0
						  /       \
Row2					 0          1
					   /   \      /   \
Row3				  0     1    1     0
					 / \   / \  / \   / \
Row4				0   1 1   01  0  0   1

Index               1   2 3   45  6  7   8

Idea :
- if k is odd, it has the same bit as parent
  - to index the parent from the previous row, k = (k + 1) / 2
- if k is even, it has the opposite bit as parent
  - to index the parent from the previous row, k = k / 2
  - but, must flip the bit too

*/