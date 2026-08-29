import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static long calculateSimilaritySum(String s) {
        int n = s.length();
        int[] z = new int[n];
        z[0] = n;
        long totalSum = n;

        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
            totalSum += z[i];
        }

        return totalSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String tLine = br.readLine();
        if (tLine == null) return;
        
        int t = Integer.parseInt(tLine.trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String s = br.readLine().trim();
            sb.append(calculateSimilaritySum(s)).append("\n");
        }

        System.out.print(sb.toString());
    }
}



Input (stdin)
2
ababaa
aa
Your Output (stdout)
11
3
Expected Output
11
3
