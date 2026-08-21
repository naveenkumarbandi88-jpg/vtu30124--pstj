class Solution {
    public boolean halvesAreAlike(String s) {
        int count1 = 0, count2 = 0;
        int mid = s.length() / 2;

        for (int i = 0; i < mid; i++) {
            if ("aeiouAEIOU".indexOf(s.charAt(i)) != -1)
                count1++;
        }

        for (int i = mid; i < s.length(); i++) {
            if ("aeiouAEIOU".indexOf(s.charAt(i)) != -1)
                count2++;
        }



Input
s =
"book"
Output
true
Expected
true
