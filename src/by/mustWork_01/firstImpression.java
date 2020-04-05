package by.mustWork_01;

import java.util.stream.IntStream;

public class firstImpression {

    public static void main(String[] args) {
        IntStream.of(10, 20, 39, 45, 0, 53, 12, 345)
                .filter(x -> x <= 45)
                .map(y -> y * 2)
                .filter(x -> x / 2 < 40)
                .sorted()
                //after sorted(): 0 20 24 40 78
                .skip(1) // - считаются с 1-го элемента а не с 0-я
                //after skip(1): 20 24 40 78
                .forEach(System.out::println);
    }
}
