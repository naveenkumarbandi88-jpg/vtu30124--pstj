import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
        // 1. Calculate Maximum Subarray Sum (Kadane's Algorithm)
        int maxSubarraySum = arr.get(0);
        int currentSubarraySum = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            currentSubarraySum = Math.max(arr.get(i), currentSubarraySum + arr.get(i));
            maxSubarraySum = Math.max(maxSubarraySum, currentSubarraySum);
        }

        // 2. Calculate Maximum Subsequence Sum
        int maxSubsequenceSum = 0;
        int maxElement = Integer.MIN_VALUE;

        for (int val : arr) {
            if (val > 0) {
                maxSubsequenceSum += val;
            }
            maxElement = Math.max(maxElement, val);
        }

        // If all elements are negative, pick the single largest (least negative) element
        if (maxElement < 0) {
            maxSubsequenceSum = maxElement;
        }

        List<Integer> result = new ArrayList<>();
        result.add(maxSubarraySum);
        result.add(maxSubsequenceSum);

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            List<Integer> result = Result.maxSubarray(arr);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

Input (stdin)
2
4
1 2 3 4
6
2 -1 2 3 4 -5
Your Output (stdout)
10 10
10 11
Expected Output
10 10
10 11



