import java.util.Arrays;
import java.util.Scanner;
public class KthSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter K: ");
        int k = sc.nextInt();
        Arrays.sort(arr);
        System.out.println(k + "th smallest element = " + arr[k - 1]);
    }
}

Output:
Enter size: 5
Enter elements:
1 2 52 10 5
Enter K: 2
2th smallest element = 2