class Solution {
    public int maxArea(int[] height) {
        int front = 0;
        int last = height.length - 1;
        int currMax = Integer.MIN_VALUE;

        while (front < last) {
            int containerHeight = Math.min(height[front], height[last]);
            int containerWidth = last - front;

            if (containerHeight * containerWidth > currMax) currMax = containerHeight * containerWidth;

            if (height[front] < height[last]) front++;
            else if (height[front] > height[last]) last--;
            else if (height[front] == height[last]) {
                front++;
                last--;
            }
        }

        return currMax;
    }
}