import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

    public static String twoStrings(String s1, String s2) {
        boolean[] present = new boolean[26];
        
        for (int i = 0; i < s1.length(); i++) {
            present[s1.charAt(i) - 'a'] = true;
        }
        
        for (int i = 0; i < s2.length(); i++) {
            if (present[s2.charAt(i) - 'a']) {
                return "YES";
            }
        }
        
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String tLine = br.readLine();
        if (tLine == null) return;
        
        int q = Integer.parseInt(tLine.trim());
        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            String s1 = br.readLine().trim();
            String s2 = br.readLine().trim();
            sb.append(twoStrings(s1, s2)).append("\n");
        }

        System.out.print(sb.toString());
    }
}


Input (stdin)
2
hello
world
hi
world
Your Output (stdout)
YES
NO
Expected Output
YES
NO
