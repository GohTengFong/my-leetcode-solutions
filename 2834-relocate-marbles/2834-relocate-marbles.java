class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Map<Integer, Integer> positions = new HashMap<>();
        
        // Initialize the positions map with initial positions and counts
        for (int i = 0; i < nums.length; i++) {
            int pos = nums[i];
            positions.put(pos, positions.getOrDefault(pos, 0) + 1);
        }
        
        // Perform the moves
        for (int i = 0; i < moveFrom.length; i++) {
            int fromPos = moveFrom[i];
            int toPos = moveTo[i];
            
            // Move the marbles from the 'fromPos' to the 'toPos'
            if (positions.containsKey(fromPos)) {
                int count = positions.get(fromPos);
                positions.remove(fromPos);  // Remove the marbles from the 'fromPos'
                positions.put(toPos, positions.getOrDefault(toPos, 0) + count);  // Add the marbles to the 'toPos'
            }
        }
        
        // Extract the occupied positions and sort them
        List<Integer> occupied = new ArrayList<>(positions.keySet());
        Collections.sort(occupied);
        return occupied;
    }
}