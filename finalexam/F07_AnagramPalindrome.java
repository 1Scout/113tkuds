import java.util.*;
public class F07_AnagramPalindrome {   
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        
        System.out.println("請輸入字串:");
        String input =scanner.nextLine();
        
        String filtered = filterLetters(input.toLowerCase());
        
        int[] frequency = new int[26];
        countFrequencyRecursive(filtered, 0, frequency);
        
        boolean canFormPalindrome = checkPalindromeCondition(frequency, 0, 0);

        System.out.println(canFormPalindrome ? "可能" : "不可能");
        
        scanner.close();
    }
    
    private static String filterLetters(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    private static void countFrequencyRecursive(String str, int index, int[] frequency) {

        if (index >= str.length()) {
            return;
        }
        
        char currentChar = str.charAt(index);
        if (currentChar >= 'a' && currentChar <= 'z') {
            frequency[currentChar - 'a']++;
        }
        
        countFrequencyRecursive(str, index + 1, frequency);
    }
    
    private static boolean checkPalindromeCondition(int[] frequency, int index, int oddCount) {
        if (index >= 26) {
            return oddCount <= 1;
        }
        
        int newOddCount=oddCount;
        if (frequency[index] % 2 == 1) {
            newOddCount++;
            if (newOddCount > 1) {
                return false;
            }
        }
        
        return checkPalindromeCondition(frequency, index + 1, newOddCount);
    }
}
