import java.util.*;

public class MinOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter total numbers: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        
        
        System.out.println("Enter the numbers: ");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println("Enter K: ");
        int K = sc.nextInt();
        
        // Step 1: Check feasibility
        int mod = A[0] % K;
        for (int i = 1; i < n; i++) {
            if (A[i] % K != mod) {
                System.out.println(-1);
                return;
            }
        }
        
        // Step 2: Normalize
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = A[i] / K;
        }
        
        // Step 3: Sort
        Arrays.sort(B);
        
        // Step 4: Median
        int median = B[n / 2];
        
        // Step 5: Count operations
        long ops = 0;
        for (int i = 0; i < n; i++) {
            ops += Math.abs(B[i] - median);
        }
        
        System.out.println("Operation: "+ops);
    }
}