package java3rd.ch14.lambda;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise14_7 {
    public static void main(String[] args) {

        // 내 풀이

        int[] dice1 = {1,2,3,4,5,6};

        Stream<Integer> diceStream1 = Arrays.stream(dice1).boxed();

        diceStream1.
                filter(i -> i+(6-i) == 6)
                .filter(i -> i != 6)
                .map(i -> "[" + i + ", " + (6-i) + "]")
                .forEach(System.out::println);

        // 자바의 정석 풀이

        Stream<Integer> die = IntStream.rangeClosed(1,6).boxed();

        die.flatMap(i -> Stream.of(1,2,3,4,5,6).map(i2 -> new int[]{i , i2}))
                .filter(iArr -> iArr[0] + iArr[1] == 6)
                .forEach(iArr -> System.out.println(Arrays.toString(iArr)));
    }
}
