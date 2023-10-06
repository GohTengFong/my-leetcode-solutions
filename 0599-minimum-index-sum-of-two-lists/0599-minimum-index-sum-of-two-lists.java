class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        ArrayList<String> tempAnswer = new ArrayList<String>();
        int currSum = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            String s = list2[j];
            
            if (map.containsKey(s)) {
                int temp = map.get(s) + j;
                
                if (temp < currSum) {
                    tempAnswer.clear();
                    currSum = temp;

                    tempAnswer.add(s);
                } else if (temp == currSum) {
                    tempAnswer.add(s);
                }
            }
        }

        String[] answer = new String[tempAnswer.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = tempAnswer.get(i);

        return answer;
    }
}