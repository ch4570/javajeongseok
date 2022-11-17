package java3rd.ch14.lambda;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise14_5 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

        // strArr을 요소로 하는 스트림 생성
        Stream<String> strStream = Stream.of(strArr);

        // strStream을 IntStream으로 변경(요소들의 길이를 정수 값으로 뽑아낸다)
        IntStream stream = strStream.mapToInt(String::length);

        // 최대값 뽑아내기
        int max1 = stream.max().getAsInt();

        // 한줄로 축약 - 1
        int max2 = Arrays.stream(strArr).mapToInt(String::length).max().getAsInt();

        System.out.println("max = " + max1);
        System.out.println("max = " + max2);
    }
}
