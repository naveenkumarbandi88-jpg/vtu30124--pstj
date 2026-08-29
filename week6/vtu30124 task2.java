class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        // Search s inside doubled string excluding the first and last characters
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}


Input
s =
"abab"
Output
true
Expected
true
