class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        LinkedList<int[]> monoStack = new LinkedList<int[]>(); // [temperature, index]

        for (int i = 0; i < temperatures.length; i++) {
            int currTemp = temperatures[i];

            while (!monoStack.isEmpty() && currTemp > monoStack.peek()[0]) {
                int[] prevPair = monoStack.pop();
                int prevTemp = prevPair[0];
                int prevIndex = prevPair[1];

                answer[prevIndex] = i - prevIndex; 
            }

            monoStack.push(new int[] {currTemp, i});
        }

        return answer;
    }
}