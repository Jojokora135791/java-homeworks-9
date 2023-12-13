package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class FirstTask {


    public static void main(String[] args)  {

        // Генерируем случайные целые числа и создаем стрим
        IntStream randomIntStream = new Random().ints(10, 1, 100); // Например, генерируем 10 чисел от 1 до 100


        List<Integer> collectedList = randomIntStream.boxed().collect(Collectors.toList());
        System.out.println("Собранная коллекция: " + collectedList);


        randomIntStream = new Random().ints(10, 1, 100);

        long countOfPrimes = randomIntStream.filter(FirstTask::isPrime).count();
        System.out.println("Количество простых чисел: " + countOfPrimes);

        randomIntStream = new Random().ints(10, 1, 100);

        OptionalInt reducedValue = randomIntStream.reduce((a, b) -> a + b);
        reducedValue.ifPresent(value -> System.out.println("Сумма всех чисел: " + value));

        randomIntStream = new Random().ints(10, 1, 100);

        randomIntStream.forEach(System.out::println);

        randomIntStream = new Random().ints(10, 1, 100);

        Map<Integer, Integer> resultMap = randomIntStream.boxed()
                .collect(Collectors.toMap(i -> i, i -> i * i)); // Пример: используем квадрат числа в качестве значения
        System.out.println("Результат в карте: " + resultMap);

    }
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}