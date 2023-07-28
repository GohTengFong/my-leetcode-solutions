class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<Integer>();

        for (int asteroid : asteroids) {
            // note that collisions ONLY happen when --> <-- (top of stack is +ve and incoming asteroid is -ve)
            while (!stack.isEmpty() && asteroid < 0 && stack.peekLast() > 0) { // conditions for collisions
                int diff = asteroid + stack.peekLast();

                if (diff < 0) { // incoming asteroid is greater than top of stack
                    stack.pollLast();
                } else if (diff > 0) { // incoming asteroid is smaller than top of stack
                    asteroid = 0; // set incoming asteroid to be 0
                } else if (diff == 0) {
                    stack.pollLast();
                    asteroid = 0;
                }
            }

            if (asteroid != 0) stack.offer(asteroid); // only adding if incoming asteroid is not 0
        }

        int[] answer = new int[stack.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.pollFirst();
        }

        return answer;
    }
}