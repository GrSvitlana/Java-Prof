package com.telran.homework.stream_api;
/*
  1. A list of words "Specific" "Measurable" "Achievable" "Relevant" "Time-bound" is given. Use streamers to output its abbreviation as S.M.A.R.T.
  2. Add the String catOwner field to the Cat class
       generate and output a Map from the list of owner's names with a number of their cats
       generate and output a Map from the list of owner's names with a list of their cats
  3. StringBuilder: write a method that takes two strings in arguments, joins them and defines a reverse order, output the result to the console.
  4. StringBuilder: takes an array of characters, join them and replace '?' with a valid character, print the result to the console.
  char[] arr = {'S', 't', 'r', 'i', '?', 'g', '', 'i', 's', '', 'i', 'm', 'm', 'u', 't', 'a', 'b', 'l', 'e'};
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    private static List<String> list = Arrays.asList("Specific", "Measurable", "Achievable", "Relevant", "Time-bound");
    private static String str1 = "Hello ";
    private static String str2 = "World!";
    private static char[] arr = new char[]{'S', 't', 'r', 'i', '?', 'g', ' ', 'i', 's', ' ', 'i', 'm', 'm', 'u', 't', 'a', 'b', 'l', 'e'};

    private static List<Cat> cats = Arrays.asList(
            new Cat("Xaver", 0, "white", false, "John"),
            new Cat("Demetrius", 1, "black", false, "Anna"),
            new Cat("Ivar", 2, "brown", true, "Anna"),
            new Cat("Taras", 3, "black white", false, "Steve"),
            new Cat("Alex", 4, "grey", true, "Alex"),
            new Cat("Verona", 5, "black", true, "John"),
            new Cat("Happy", 1, "blue", false, "Amanda"),
            new Cat("Zeus", 1, "red white", false, "Merve"),
            new Cat("Faina", 6, "red", false, "Anna")
    );


    public static void main(String[] args) {

        System.out.println("A list of words Specific, Measurable, Achievable, Relevant, Time-bound abbreviates as S.M.A.R.T.:");
        abbreviate(list);

        System.out.println("\nGenerate and output a map from the list of owner's names with a number of their cats:");
        System.out.println(mapOfOwnersWithCounting(cats));

        System.out.println("\nGenerate and output a map from the list of owner's names with a list of their cats:");
        System.out.println(mapOfOwnersAndCats(cats));

        System.out.println("\nThis method takes two strings in arguments, joins them and defines a reverse order:");
        System.out.println(joinStringAndReversePrint(str1, str2));

        System.out.println("\nThis method takes an array of characters, join them and replace '?' with a valid character:");
        System.out.println(joinCharAndReversePrint(arr));
    }

    public static void abbreviate(List<String> list) {
        list.stream().map(s -> s.charAt(0)).forEach(s -> System.out.print(s + "."));
    }

    public static Map<String, Long> mapOfOwnersWithCounting(List<Cat> cats) {
        return cats.stream().collect(Collectors.groupingBy(Cat::getCatOwner, Collectors.counting()));
    }

    public static Map<String, String> mapOfOwnersAndCats(List<Cat> cats) {
        return cats.stream().collect(Collectors.toMap(Cat::getCatOwner, Cat::getName, (x, y) -> x + " & " + y));
    }

    public static String joinStringAndReversePrint(String str1, String str2) {
        return new StringBuilder().append(str1).append(str2).reverse().toString();
    }

    public static String joinCharAndReversePrint(char[] arr) {
        return new StringBuilder().append(arr).toString().replace('?', 'n');
    }
}
