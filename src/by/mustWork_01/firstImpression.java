package by.mustWork_01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class firstImpression {

    public static void main(String[] args) throws IOException {
//        IntStream.of(10, 20, 39, 45, 0, 53, 12, 345)
//                .filter(x -> x <= 45)
//                .map(y -> y * 2)
//                .filter(x -> x / 2 < 40)
//                .sorted()
//                //after sorted(): 0 20 24 40 78
//                .skip(1) // - считаются с 1-го элемента а не с 0-я
//                //after skip(1): 20 24 40 78
//                .limit(2)
//                //after limit(2): 20 24
//                .forEach(System.out::println);

        //1. Создание стрима из значений

        Stream<Integer> streamFromIntegers = Stream.of(1, 3, 4, 5, 6, 67, 657);

        System.out.println("1. Создание стрима из значений streamFromIntegers: " + streamFromIntegers.collect(toList()));

        //2. Создание стрима из массива
        //a
        Integer[] arrayInt = {1, 2, 3, 4, 5, 6, 7};
        Stream<Integer> streamFromArray = Arrays.stream(arrayInt);

        System.out.println("2. Создание стрима из массива streamFromArray: " + streamFromArray.collect(toList()));
        //b
        Stream<Integer> streamOfArray = Stream.of(arrayInt);

        System.out.println("2. Создание стрима из массива streamOfArray: " + streamOfArray.collect(toList()));

        //3. Создание стрима из файла (каждая запись в файле будет отдельной строкой в стриме)

        File file = new File("D:\\home_Projects\\udemy\\practice-java-building-projects\\Streams\\src\\by\\mustWork_01\\file.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("This is a content of my new created file");
        fileWriter.write("\nanother line of the text!");
        fileWriter.write("\nthird line of the text!");
        fileWriter.close(); // ничего не запишет пока не закроем поток записи
        Stream<String> streamFromFile = Files.lines(Paths.get(file.getAbsolutePath()));
        System.out.println("3. Создание стрима из файла (каждая запись в файле будет отдельной строкой в стриме) streamFromFile: " + streamFromFile.collect(toList()));

        //4. Создание стрима из коллекции
        List<String> list = new ArrayList<>();
        list.add("Cat");
        list.add("Milk");
        list.add("Cow");
        list.add("Horse");
        list.add("Sand");
        Stream<String> streamFromList = list.stream();

        System.out.println("4. Создание стрима из коллекции streamFromList: " + streamFromList.collect(toList()));

        //5. Создание числового стрима из строки

        String sequence = "I don't know what to put here.";
        IntStream streamFromSequence = sequence.chars();

        System.out.print("5. Создание числового стрима из строки streamFromSequence: ");
        streamFromSequence.forEach((e) -> System.out.print(e + ", "));
        System.out.println();

        //6. С помощью Stream.builder

        Stream.Builder<String> builder = Stream.builder();
        Stream<String> streamFromBuilder = builder.add("a1").add("a2").add("a3").build();
        System.out.println("6. Создание стрима с помощью Stream.builder: " + streamFromBuilder.collect(toList()));


        //7. Создание бесконечных стримов
        // С помощью Stream.iterate

        Stream<Integer> streamIterate = Stream.iterate(1, x -> x + 2);
        System.out.println("7. Создание бесконечных стримов c Stream.iterate: " + streamIterate.limit(10).collect(toList()));

        //8. С помощью Stream.generate
        Stream<String> streamGenerate = Stream.generate(() -> "abc");
        System.out.println("8. Создание бесконечных стримов с помощью Stream.generate: " + streamGenerate.limit(5).collect(toList()));

        //9. Создать параллельный стрим из коллекции
        Collection<String> stringCollection = Collections.singletonList("String message");
        Stream<String> parallelStreamFromCollection = stringCollection.parallelStream();

        System.out.println("9. Создать параллельный стрим из коллекции parallelStreamFromCollection: " + parallelStreamFromCollection.collect(Collectors.toList()));

        //10. Создать пустой стрим

        Stream<String> streamEmpty = Stream.empty();
        System.out.println("10. Создать пустой стрим: " + streamEmpty.collect(toList()));

        // пробные варианты
        //Java 9 +
        System.out.println( "Stream.iterate: "+ Stream.iterate((1), x -> x < 20, x -> x + 1).collect(Collectors.toList()));

        for (int i = 0; i <85 ; i++) {
            System.out.print("_");
        }
        System.out.println();

        // Stream.Builder мутированный
        Stream.Builder<Integer> streamMutable = Stream.builder();
        streamMutable.add(14);

        for (int i = 48; i > 14; i--) {
            streamMutable.accept(i);
        }
        System.out.println("streamMutable: " + streamMutable.build().collect(Collectors.toList()));
        // не работает - поток закрыт
//        streamMutable.accept(0);
//        System.out.println("streamMutable: " + streamMutable.build().collect(Collectors.toList()));

        //Stream.concat
        System.out.println("Stream.concat: "+Stream.concat(Stream.of(10,20,30), Stream.builder().add(12).add(13).add(15).build())
                .collect(Collectors.toList()));


    }
}
