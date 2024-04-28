package Q002;
/*344.문자열 뒤집기*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        int start = 0, end = s.length - 1;

        // 임시변수 temp 를 이용하여 스왑
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}
