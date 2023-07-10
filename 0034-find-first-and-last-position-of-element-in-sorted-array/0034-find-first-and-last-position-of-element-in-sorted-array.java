class Solution {
    private int binarySearchFirst(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }

        return (nums[start] == target ? start : -1);
    }

    private int binarySearchLast(int[] nums, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] <= target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            }
        }

        return (nums[end] == target) ? end : start;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];

        if (nums.length == 1 && nums[0] == target) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        } else if (nums.length == 0) {
            answer[0] = -1;
            answer[1] = -1;
            return answer;
        }

        int first = binarySearchFirst(nums, 0, nums.length - 1, target);

        if (first == -1) {
            answer[0] = -1;
            answer[1] = -1;
            return answer;
        } else {
            int last = binarySearchLast(nums, 0, nums.length - 1, target);
            answer[0] = first;
            answer[1] = last;
            return answer;
        }
    }
}