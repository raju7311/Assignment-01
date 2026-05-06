import java.util.*;

public class CyclicMaxSum {
    public static void main(String[] args) {
        System.out.println("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        int n = s.length();
        String t = s + s; // circular simulation
        
        int[] freq = new int[26];
        int left = 0, maxSum = 0, currSum = 0;
        
        for (int right = 0; right < 2 * n; right++) {
            char ch = t.charAt(right);
            int val = ch - 'a';
            
            // include character
            freq[val]++;
            currSum += (val + 1);
            
            // remove duplicates or window > n
            while (freq[val] > 1 || (right - left + 1) > n) {
                char leftChar = t.charAt(left);
                int leftVal = leftChar - 'a';
                
                freq[leftVal]--;
                currSum -= (leftVal + 1);
                left++;
            }
            
            maxSum = Math.max(maxSum, currSum);
        }
        
        System.out.println(maxSum);
    }
}