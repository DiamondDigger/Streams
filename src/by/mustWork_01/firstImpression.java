package by.mustWork_01;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
                .limit(2)
                //after limit(2): 20 24
                .forEach(System.out::println);

        // бесконечный stream через iterate
        Stream<Integer> newStream = Stream.iterate(1, n -> n * 5);
        System.out.println("newStream : "+ newStream.limit(5).collect(Collectors.toList()));
    }
}
