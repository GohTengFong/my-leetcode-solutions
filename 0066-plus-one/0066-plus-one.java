class Solution {
    private int[] copy(int[] newArray, int[] oldArray) {
        newArray[0] = 1;

        for (int i = 0; i < oldArray.length; i++) {
            newArray[i + 1] = oldArray[i];
        }

        return newArray;
    }

    public int[] plusOne(int[] digits) {
        int carry = 0;

        if (digits[digits.length - 1] + 1 != 10) {
            digits[digits.length - 1] += 1;
            return digits;
        } else {
            digits[digits.length - 1] = 0;
            carry = 1;
        }

        int i = digits.length - 2;

        while (carry != 0) {
            if (i < 0) {
                int[] newArray = new int[digits.length + 1];

                return copy(newArray, digits);
            }

            if (digits[i] + carry != 10) {
                digits[i] += carry;
                carry = 0;
            } else {
                digits[i] = 0;
                i--;
            }
        }

        return digits;
    }
}