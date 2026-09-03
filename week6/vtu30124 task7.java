import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try removing character at 'left'
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                }
                // Try removing character at 'right'
                if (isPalindrome(s, left, right - 1)) {
                    return right;
                }
                return -1;
            }
            left++;
            right--;
        }

        return -1; // String is already a palindrome
    }

    // Helper method to check if substring from start to end is a palindrome
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            int result = Result.palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}



Input (stdin)
3
aaab
baa
aaa
Your Output (stdout)
3
0
-1
Expected Output
3
0
-1
