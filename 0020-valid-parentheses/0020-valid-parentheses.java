class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (s.charAt(i) == ')') {
                    Character nextChar = (Character) stack.pop();
                    
                    if (nextChar != '(') {
                        return false;
                    }
                } else if (s.charAt(i) == ']') {
                    Character nextChar = (Character) stack.pop();
                    
                    if (nextChar != '[') {
                        return false;
                    }
                } else if (s.charAt(i) == '}') {
                    Character nextChar = (Character) stack.pop();
                    
                    if (nextChar != '{') {
                        return false;
                    }
                } else {
                    continue;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}