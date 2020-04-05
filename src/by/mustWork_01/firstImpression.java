package by.mustWork_01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class firstImpression {

    public static void main(String[] args) throws IOException {
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

        //1. Создание стрима из значений

        Stream<Integer> streamFromIntegers = Stream.of(1,3,4,5,6,67,657);

        System.out.println("1. Создание стрима из значений streamFromIntegers: "+streamFromIntegers.collect(toList()));

        //2. Создание стрима из массива
        //a
        Integer[] arrayInt = {1,2,3,4,5,6,7};
        Stream<Integer> streamFromArray = Arrays.stream(arrayInt);

        System.out.println("2. Создание стрима из массива streamFromArray: "+ streamFromArray.collect(toList()));
        //b

        //3. Создание стрима из файла (каждая запись в файле будет отдельной строкой в стриме)
        File file = new File("D:\\home_Projects\\udemy\\practice-java-building-projects\\Streams\\src\\by\\mustWork_01\\file.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("This is a content of my new created file");
        Stream<String> streamFromFile = Stream.of(file.toString());

        System.out.println("3. Создание стрима из файла (каждая запись в файле будет отдельной строкой в стриме) streamFromFile: "+ streamFromFile.collect(toList()));


        //4. Создание стрима из коллекции
        List<String> list = new ArrayList<>();
        list.add("Cat");
        list.add("Milk");
        list.add("Cow");
        list.add("Horse");
        list.add("Sand");
        Stream<String> streamFromList = list.stream();

        System.out.println("4. Создание стрима из коллекции streamFromList: "+ streamFromList.collect(toList()));

        //5. Создание числового стрима из строки

        String sequence = "I don't know what to put here.";
        IntStream streamFromSequence = sequence.chars();

        System.out.print("5. Создание числового стрима из строки streamFromSequence: ");
        streamFromSequence.forEach((e)-> System.out.print(e + ", "));


        //6. С помощью Stream.builder

        //7. Создание бесконечных стримов
        // С помощью Stream.iterate

        //8. С помощью Stream.generate

        //9. Создать параллельный стрим из коллекции



















        // бесконечный stream через iterate
        Stream<Integer> newStream = Stream.iterate(1, n -> n * 5);
        System.out.println("newStream : "+ newStream.limit(5).collect(toList()));
    }
}
