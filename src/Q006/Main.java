package Q006;
/*5.가장 긴 팰린드롬 부분 문자열*/

public class Main {

    static int left, maxLen;

    public static void main(String[] args) {
        String ans = "dcbabcdd";
        System.out.println(longestPalindrome(ans));
    }

    //팰린드롬 확장
    public static void extendPalindrome(String s, int j, int k) {

        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        if (maxLen < k - j - 1) {
            left = j+1;
            maxLen = k - j - 1;
        }
    }

    public static String longestPalindrome(String s) {
        int len = s.length();

        // 길이 1인 문자열은 그대로
        if (len < 2) return s;

        // 투 포인터
        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i+1);
            extendPalindrome(s, i, i + 2);
        }
        return s.substring(left, left + maxLen);
    }
}
