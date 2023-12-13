package org.example;

import java.util.*;
import java.util.stream.*;

public class SecondTask {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("apple", "banana", "orange", "grape", "watermelon", "pineapple");

        char startingLetter = 'a';
        List<String> filteredByLetter = stringList.stream()
                .filter(s -> s.charAt(0) == startingLetter)
                .collect(Collectors.toList());
        System.out.println("Элементы, начинающиеся с буквы '" + startingLetter + "': " + filteredByLetter);

        List<String> upperCaseList = stringList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Строки в верхнем регистре: " + upperCaseList);

        String substringToCheck = "ap";
        long countSubstring = stringList.stream()
                .filter(s -> s.contains(substringToCheck))
                .count();
        System.out.println("Количество элементов, содержащих подстроку '" + substringToCheck + "': " + countSubstring);

        List<String> sortedByLength = stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Элементы, отсортированные по длине: " + sortedByLength);

        Optional<String> firstElement = stringList.stream().findFirst();
        firstElement.ifPresent(element -> System.out.println("Первый элемент: " + element));
    }
}
