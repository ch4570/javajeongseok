package java3rd.ch14.lambda;


import java.util.Random;
import java.util.stream.IntStream;

public class Exercise14_6 {
    public static void main(String[] args) {

        // 기본형 스트림에 난수를 발생시키는 스트림을 저장
        IntStream intStream = new Random().ints(1,46);

        // 중복제거 -> 요소의 개수 제한 -> 정렬 -> 모든 요소 출력 순으로 스트림을 소모함
        intStream.
                distinct().                     // 중복제거
                limit(6).                       // 요소의 개수 제한
                sorted().                       // 정렬
                forEach(System.out::println);   // 모든 요소 출력

        // 한줄로 축약 (따로 스트림에 저장하지 않고, 바로 난수를 발생시켜 스트림을 소모시키면서 출력)
        new Random().ints(1, 46)
                .distinct()
                .limit(6)
                .sorted()
                .forEach(System.out::println);
    }
}
