package java3rd.ch14.lambda;

import java.util.Arrays;

public class Exercise14_5 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};
        int max = Arrays.stream(strArr).mapToInt(String::length).max().getAsInt();

        System.out.println("max = " + max);
    }
}
