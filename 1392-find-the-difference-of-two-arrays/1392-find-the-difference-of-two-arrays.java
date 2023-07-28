class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        for (int num : nums2) {
            if (set1.contains(num)) set1.remove(num);
        }
        for (int num : nums1) {
            if (set2.contains(num)) set2.remove(num);
        }

        for (int num : set1) list1.add(num);
        for (int num : set2) list2.add(num);

        answer.add(list1);
        answer.add(list2);

        return answer;
    }
}