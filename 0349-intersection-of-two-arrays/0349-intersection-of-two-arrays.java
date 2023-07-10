class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int index1 = 0;
        int index2 = 0;
        int i = 0;

        while (index1 != nums1.length && index2 != nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                if (!set.contains(nums1[index1])) {
                    set.add(nums1[index1]);
                    list.add(nums1[index1]);
                }

                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            }
        }

        int[] answer = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            answer[j] = list.get(j);
        }

        return answer;
    }
}