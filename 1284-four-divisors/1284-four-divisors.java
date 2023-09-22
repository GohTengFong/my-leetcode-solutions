class Solution {
    private HashSet<Integer> checkDivisors(int num) {
        HashSet<Integer> divisors = new HashSet<Integer>();
        divisors.add(1);
        divisors.add(num);
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (divisors.contains(i)) continue;
            
            if (num % i == 0) {
                int otherDivisor = num / i;

                divisors.add(i);
                divisors.add(otherDivisor);
            }

            if (divisors.size() > 4) break;
        }

        return divisors;
    }

    public int sumFourDivisors(int[] nums) {
        int answer = 0;

        for (int num : nums) {
            HashSet<Integer> divisors = checkDivisors(num);

            if (divisors.size() == 4) {
                for (int divisor : divisors) answer += divisor;
            }
        }

        return answer;
    }
}