class Solution {
    private void fillTriangle(int row, List<List<Integer>> mainList) {
        List<Integer> list = new ArrayList<Integer>();

        if (row == 0) {
            list.add(1);
            mainList.add(list);
        } else {
            List<Integer> prevList = mainList.get(row - 1);

            for (int i = 0; i <= prevList.size(); i++) {
                if (i == 0 || i == prevList.size()) {
                    list.add(1);
                } else {
                    list.add(prevList.get(i - 1) + prevList.get(i));
                }
            }

            mainList.add(list);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> mainList = new ArrayList<List<Integer>>();

        int counter = 0;

        while (numRows != 0) {
            fillTriangle(counter, mainList);
            numRows -= 1;
            counter += 1;
        }
        
        return mainList;    
    }
}