class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> nums = new Stack<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int first = nums.pop();
                int next = nums.peek() + first;
                nums.push(first);
                nums.push(next);
            } else if (op.equals("D")) {
                int first = nums.peek();
                nums.push(first * 2);
            } else if (op.equals("C")) {
                nums.pop();
            } else {
                //number to be inserted
                nums.push(Integer.valueOf(op));
            }
        }
        
        int ans = 0;
        while (!nums.isEmpty()) {
            ans += nums.pop();
        }
        return ans;
    }
}