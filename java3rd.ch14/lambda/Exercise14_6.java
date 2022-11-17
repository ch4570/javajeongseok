package java3rd.ch14.lambda;


import java.util.Random;
import java.util.stream.IntStream;

public class Exercise14_6 {
    public static void main(String[] args) {
        IntStream intStream = new Random().ints(1,46);
        intStream.distinct().limit(6).sorted().forEach(System.out::println);
    }
}
