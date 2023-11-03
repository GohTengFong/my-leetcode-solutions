class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> answer = new ArrayList<String>();

        int i = 0;
        int count = 1;
        while (count <= n) {
            int toAdd = target[i];

            while (count != toAdd) {
                answer.add("Push");
                answer.add("Pop");
                count++;
            }

            answer.add("Push");

            count++;
            i++;

            if (i == target.length) return answer;
        }

        return answer;
    }
}