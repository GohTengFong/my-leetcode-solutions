class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int secondVal = stack.pop();
                int firstVal = stack.pop();

                stack.push(firstVal + secondVal);
            } else if (token.equals("-")) {
                int secondVal = stack.pop();
                int firstVal = stack.pop();

                stack.push(firstVal - secondVal);
            } else if (token.equals("*")) {
                int secondVal = stack.pop();
                int firstVal = stack.pop();

                stack.push(firstVal * secondVal);
            } else if (token.equals("/")) {
                int secondVal = stack.pop();
                int firstVal = stack.pop();

                stack.push(firstVal / secondVal);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}