class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();

        int count = 1;

        while (count != n + 1) {
            if (count % 15 == 0) {
                list.add("FizzBuzz");
            } else if (count % 3 == 0) {
                list.add("Fizz");
            } else if (count % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(Integer.toString(count));
            }

            count += 1;
        }

        return list;
    }
}