import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

    public static int marsExploration(String s) {
        int count = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char expectedChar = (i % 3 == 1) ? 'O' : 'S';
            if (s.charAt(i) != expectedChar) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        if (s != null) {
            s = s.trim();
            System.out.println(marsExploration(s));
        }
    }
}


Input (stdin)
SOSSPSSQSSOR
Your Output (stdout)
3
Expected Output
3
