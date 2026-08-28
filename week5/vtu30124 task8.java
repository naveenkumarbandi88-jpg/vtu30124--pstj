import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean matches(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        
        // Tracking character mappings in both directions
        int[] wordToPattern = new int[26];
        int[] patternToWord = new int[26];
        
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            
            // Map char to 1-based index (0 means unmapped)
            int wVal = w - 'a' + 1;
            int pVal = p - 'a' + 1;
            
            if (wordToPattern[w - 'a'] == 0 && patternToWord[p - 'a'] == 0) {
                wordToPattern[w - 'a'] = pVal;
                patternToWord[p - 'a'] = wVal;
            } else if (wordToPattern[w - 'a'] != pVal || patternToWord[p - 'a'] != wVal) {
                return false;
            }
        }
        
        return true;
    }
}


Input
words =
["abc","deq","mee","aqq","dkd","ccc"]
pattern =
"abb"
Output
["mee","aqq"]
Expected
["mee","aqq"]
