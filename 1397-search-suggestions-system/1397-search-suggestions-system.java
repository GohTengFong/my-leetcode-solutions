class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        ArrayList<List<String>> answer = new ArrayList<List<String>>();

        Arrays.sort(products);
        char[] chars = searchWord.toCharArray();

        int topPointer = 0;
        int bottomPointer = products.length - 1;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            while (topPointer <= bottomPointer && (products[topPointer].length() <= i || products[topPointer].charAt(i) != c)) {
                topPointer++;
            }
            while (topPointer <= bottomPointer && (products[bottomPointer].length() <= i || products[bottomPointer].charAt(i) != c)) {
                bottomPointer--;
            }

            ArrayList<String> temp = new ArrayList<String>();
            int windowSize = bottomPointer - topPointer + 1;
            for (int j = 0; j < Math.min(windowSize, 3); j++) {
                temp.add(products[topPointer + j]);
            }

            answer.add(temp);
        }

        return answer;
    }
}