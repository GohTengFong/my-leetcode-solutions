class Solution {
    private void insertToSet(String str, HashSet<Character> set) {
        char[] charArray = str.toCharArray();

        for (char c : charArray) set.add(c);
    }

    private void removeFromSet(String str, HashSet<Character> set) {
        char[] charArray = str.toCharArray();

        for (char c : charArray) set.remove(c);
    }

    private boolean checkIfValid(String str, HashSet<Character> set) {
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            if (set.contains(c)) return false;
        }

        return true;
    }

    private boolean validString(String str) {
        HashSet<Character> set = new HashSet<Character>();
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            if (set.contains(c)) return false;
            else set.add(c);
        }

        return true;
    }

    private int dfs(List<String> arr, HashSet<Character> set, StringBuilder sb, int start) {
        if (start == arr.size()) return sb.length();

        int currSize = sb.length();
        int maxSoFar = sb.length();
        
        for (int i = start; i < arr.size(); i++) {
            String nextString = arr.get(i);

            if (!validString(nextString)) continue;

            if (checkIfValid(nextString, set)) {
                sb.append(nextString);
                insertToSet(nextString, set);
                
                maxSoFar = Math.max(dfs(arr, set, sb, i + 1), maxSoFar);

                removeFromSet(nextString, set);
                sb.delete(currSize, sb.length());
            } else {
                continue;
            }
        }

        return maxSoFar;
    }

    public int maxLength(List<String> arr) {
        HashSet<Character> set = new HashSet<Character>();
        StringBuilder sb = new StringBuilder();
        int max = 0;

        for (int i = 0; i < arr.size(); i++) {
            String currString = arr.get(i);

            if (!validString(currString)) continue;
            
            insertToSet(currString, set);
            sb.append(currString);
                
            max = Math.max(dfs(arr, set, sb, i + 1), max);

            sb.delete(0, sb.length());
            removeFromSet(currString, set);
        }

        return max;
    }
}