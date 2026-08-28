import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
   Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0)
        {
            String s = sc.next();
            int n = s.length();

            int[] first = new int[26];
            int[] second = new int[26];

            // First half
            for (int i = 0; i < n / 2; i++)
            {
                first[s.charAt(i) - 'a']++;
            }

            // Second half, skipping middle character if length is odd
            for (int i = (n + 1) / 2; i < n; i++)
            {
                second[s.charAt(i) - 'a']++;
            }

            if (Arrays.equals(first, second))
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        sc.close();
    }
}

	

output:

Sample Input
6
gaga
abcde
rotor
xyzxy
abbaab
ababc

Your Output
YES
NO
YES
YES
NO
NO