class Solution {
    private boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        } else if (str1.length() == 0 && str2.length() == 0) {
            return true;
        }

        char[] letters = new char[26];

        for (int i = 0; i < str1.length(); i++) {
            letters[str1.charAt(i) - 'a'] += 1;
            letters[str2.charAt(i) - 'a'] -= 1;
        }

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<List<String>>();

        boolean[] seen = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList<String>();
            
            if (!seen[i]) {
                list.add(strs[i]);
                seen[i] = true;

                for (int j = i + 1; j <= strs.length - 1; j++) {
                    if (!seen[j] && isAnagram(strs[i], strs[j])) {
                        list.add(strs[j]);
                        seen[j] = true;
                    }
                }
            } else {
                continue;
            }

            answer.add(list);
        }

        return answer;
    }
}