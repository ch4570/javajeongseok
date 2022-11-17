package java3rd.ch14.lambda;

import java.util.Arrays;

public class Exercise14_4 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};
        int sum = Arrays.stream(strArr).mapToInt(String::length).sum();

        System.out.println("sum = " + sum);
    }
}
