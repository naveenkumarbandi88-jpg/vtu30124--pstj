import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < pLen) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

       
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

       
        if (matches(pCount, sCount)) {
            result.add(0);
        }

   
        for (int i = pLen; i < sLen; i++) {
            
            sCount[s.charAt(i) - 'a']++;
       
            sCount[s.charAt(i - pLen) - 'a']--;

           
            if (matches(pCount, sCount)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}


Input
s =
"cbaebabacd"
p =
"abc"
Output
[0,6]
Expected
[0,6]
