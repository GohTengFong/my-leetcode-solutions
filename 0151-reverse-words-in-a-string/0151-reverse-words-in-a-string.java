class Solution {
    public String reverseWords(String s) {
        String[] sSplit = s.split(" ");
        
        int front = 0;
        int last = sSplit.length - 1;

        while (front < last) {
            String temp = sSplit[front];
            sSplit[front] = sSplit[last];
            sSplit[last] = temp;

            front++;
            last--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sSplit.length; i++) {
            if (sSplit[i].equals("")) continue;
            else sb.append(sSplit[i] + " ");
        }

        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
    }
}