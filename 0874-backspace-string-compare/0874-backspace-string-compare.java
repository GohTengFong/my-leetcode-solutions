class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<Character>();
        Stack<Character> stackT = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (c == '#' && !stackS.isEmpty()) stackS.pop();
            else if (c != '#') stackS.push(c);
        }

        for (char c : t.toCharArray()) {
            if (c == '#' && !stackT.isEmpty()) stackT.pop();
            else if (c != '#') stackT.push(c);
        }

        return stackS.equals(stackT);
    }
}