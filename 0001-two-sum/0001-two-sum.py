class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        answer = []
        hashmap = {}

        for i in range(len(nums)):
            if target - nums[i] in hashmap:
                answer.append(hashmap[target - nums[i]])
                answer.append(i)
                return answer
            
            hashmap[nums[i]] = i

        return answer