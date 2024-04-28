package Q001;
/*125.유효한 팰린드롬*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(isPalindrome1(s));
        System.out.println(isPalindrome2(s));

    }
    // 원시 자료형을 비교하기 때문에 속도가 더 빠르다.
    public static boolean isPalindrome1(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            // 문자와 숫자만 판별하기 위해 포인터 이동
            if(!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    // 코드는 간결하지만 클래스를 직접 비교하는 방식이어서 속도가 느리다.
    public static boolean isPalindrome2(String s) {
        // 문자와 숫자만 남김(공백, 특수문자 제거)
        String s_filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String s_reversed = new StringBuilder(s_filtered).reverse().toString();
        return s_filtered.equals(s_reversed);
    }
}
