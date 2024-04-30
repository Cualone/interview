package Q003;
/*937.로그 파일 재정렬*/
/*
* Collections.sort()
* 값이 동일하면 0, 비교 대상의 순서가 앞일 경우 1, 비교 대상의 순서가 뒤라면 -1 반환
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(",");
        System.out.println(Arrays.toString(reorderLogFiles(input)));
    }

    public static String[] reorderLogFiles(String[] logs) {
        // 문자 로그 저장
        List<String> letterList = new ArrayList<>();
        // 숫자 로그 저장
        List<String> digitList = new ArrayList<>();

        // 문자, 숫자 로그 구별
        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }

        letterList.sort((s1, s2) -> {
            String[] s1x = s1.split(" ");
            String[] s2x = s2.split(" ");

            int compared = s1x[1].compareTo(s2x[1]);
            if (compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            } else {
                return compared;
            }
        });

        letterList.addAll(digitList);
        return letterList.toArray(new String[0]);
    }
}
