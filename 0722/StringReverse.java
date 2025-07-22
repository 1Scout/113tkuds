import java.util.*;
public class StringReverse {
    
    public static String reverseString(String str) {
        // 停止條件：空字串或單字符
        if (str.length() <= 1) {
            return str;
        }
        // 遞迴關係：最後一個字符 + 反轉前面的部分
        return str.charAt(str.length() - 1) + 
               reverseString(str.substring(0, str.length() - 1));
    }
    
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("請輸入要反轉的字串:");
        String target=scanner.nextLine();
        System.out.println("反轉 "+target+":"+ reverseString(target));         
    }
}