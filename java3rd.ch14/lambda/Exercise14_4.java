package java3rd.ch14.lambda;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise14_4 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

        // strArr을 요소로 하는 스트림 생성
        Stream<String> strSTream = Stream.of(strArr);

        // 요소들의 길이들을 요소로 하는 정수형 스트림으로 변환
        IntStream intStream = strSTream.mapToInt(String::length);

        // 요소들을 모두 더해서 출력
        System.out.println("sum = "  + intStream.sum());

        // 합계를 구하는 코드를 한줄로 축약 - 1
        int sum1 = Arrays.stream(strArr).mapToInt(String::length).sum();

        System.out.println("sum = " + sum1);
    }
}
