package com.telran.homework.stream_api;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import static java.util.Collections.reverseOrder;

/**
 * 1. Create Supplier, that generates random values of Integer type.
 * 2. Create BiFunction, that takes the first argument of int to the power of the second argument of int.
 * 3. Sort a list of strings with Streams (alphabetically, in reverse order)
 * 4. From an int list, use streams to create a list of their string representations.
 * 5. Create a Cat class with fields:
 * String name
 * int age
 * String color
 * boolean isHungry
 * Create a list of Cat class instances with the help of streamers:
 * output a list of hungry cats over 2 years old
 * display a list of black cats with names beginning with T
 * display a list of names of cats 1 year old.
 */

public class Main {
    public static void main(String[] args) {
        Supplier<Integer> randomSupplier = new Random()::nextInt;
        System.out.println(randomSupplier.get());

        BiFunction<Integer, Integer, Double> biFunction = Math::pow;
        System.out.println(biFunction.apply(10, 6));

        List<String> list = Arrays.asList(("Lorem ipsum dolor sit amet, " +
                "consetetur sadipscing elitr, sed diam nonumy eirmod tempor " +
                "invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. " +
                "At vero eos et accusam et justo duo dolores et ea rebum").split(""));

        list
                .stream()
                .sorted()
                .toList()
                .forEach(System.out::print);
        System.out.print("\n");

        list
                .stream()
                .sorted(reverseOrder())
                .toList()
                .forEach(System.out::print);

        List<Integer> listInteger = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> listString = listInteger
                .stream()
                .map(Object::toString)
                .toList();
        System.out.println("\n" + listString);

        List<Cat> cats = Arrays.asList(
                new Cat("Xaver", 0, "white", false),
                new Cat("Demetrius", 1, "black", false),
                new Cat("Ivar", 2, "brown", true),
                new Cat("Taras", 3, "black white", false),
                new Cat("Alex", 4, "grey", true),
                new Cat("Verona", 5, "black", true)
        );

        cats
                .stream()
                .filter(Cat::isHungry)
                .filter(c -> c.getAge() > 2)
                .toList()
                .forEach(System.out::println);
        System.out.print("\n" + "-".repeat(20) + "\n");

        cats
                .stream()
                .filter(c -> c.getColour().contains("black") && c.getName().startsWith("T"))
                .forEach(System.out::println);
        System.out.print("\n" + "-".repeat(20) + "\n");

        cats
                .stream()
                .filter(c -> c.getAge() == 1)
                .forEach(c -> System.out.print(c.getName()));
    }
}
