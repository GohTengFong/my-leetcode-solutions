class Solution {
    public String removeStars(String s) {
        char[] charArray = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<Character>();

        for (char c : charArray) {
            if (c == '*') {
                stack.pollLast();
            } else {
                stack.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        return sb.toString();
    }
}