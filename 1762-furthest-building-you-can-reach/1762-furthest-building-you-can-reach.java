class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        int heightDiff = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1]) continue;
            
            heightDiff = heights[i + 1] - heights[i];
            maxHeap.offer(heightDiff);

            if (bricks >= heightDiff) {
                bricks -= heightDiff;
            } else {
                while (bricks < heightDiff && ladders != 0) {
                    int prevMax = maxHeap.poll();
                    bricks += prevMax;
                    ladders--;
                }

                if (ladders == 0 && bricks < heightDiff) return i;
                else bricks -= heightDiff;
            }
        }

        return heights.length - 1;
    }
}

/*

Idea :
- maintain a maxHeap that tracks the bricks used at each jump
- iterate through heights
  - if bricks > heightDiff, we can reach the next height by using bricks
  - else, we have to use our ladders
- maxHeap.poll() to extract the previous maximum brick usage
- replace this brick usage with a single ladder use
- number of remaining bricks = 0 + maxHeap.poll()
- number of ladders -= 1
- repeat until bricks < heightDiff && ladders == 0

*/