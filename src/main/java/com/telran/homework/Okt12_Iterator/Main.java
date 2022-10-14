package com.telran.homework.Okt12_Iterator;
/*
1. создать лист, наполнить его 10М> елементами
2. внутри тела кладем i- тый элемент в переменную temp
3. перебрать for-each loop
4. classic for и вызываем list.size() для каждой итерации
5. classic for, но list.size() определяем в переменную
6. classic for, list.size() определяем в переменную, перебираем с конца (i--)
7. используя Itertor
8. используя ListIterator
для всех случаев сделать замер времени
результат вывести в консоль
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int temp;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            temp = random.nextInt(100);
            list.add(i, temp);
        }

        long timeForEach = foreachMethod(list);
        long timeclassicForI = classicForMethodI(list);
        long timeclassicForPlus = classicForMethodPlus(list);
        long timeclassicForMinus = classicForMethodMinus(list);
        long timeIterator = iteratorMethod(list);
        long timeIteratorI = iteratorMethodI(list);
        long timeIteratorPlus = iteratorMethodPlus(list);
        long timeIteratorMinus = iteratorMethodMinus(list);

        System.out.printf("\n %s = %d\n %s = %d\n %s = %d\n %s = %d\n %s = %d\n %s = %d\n %s = %d\n %s = %d\n",
                "timeForEach", timeForEach,
                "timeclassicForI", timeclassicForI,
                "timeclassicForPlus", timeclassicForPlus,
                "timeclassicForMinus", timeclassicForMinus,
                "timeIterator", timeIterator,
                "timeIteratorI", timeIteratorI,
                "timeIteratorPlus", timeIteratorPlus,
                "timeIteratorMinus", timeIteratorMinus);

        List<Long> time = new ArrayList<>(Arrays.asList(timeForEach, timeclassicForI, timeclassicForPlus, timeclassicForMinus,
                timeIterator, timeIteratorI, timeIteratorPlus, timeIteratorMinus));
        Collections.sort(time);
        System.out.println(time);
    }

    private static long foreachMethod(List<Integer> list) {
        long startTime = System.nanoTime();
        for (Integer elements : list) {
            System.out.print(elements + " ");
        }
        long stopTime = System.nanoTime();
        long foreachMethodTime = stopTime - startTime;
        System.out.println();
        return foreachMethodTime;
    }

    private static long classicForMethodI(List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d %d ", list.get(i), list.size());
        }
        long stopTime = System.nanoTime();
        long classicForMethodITime = stopTime - startTime;
        System.out.println();
        return classicForMethodITime;
    }

    private static long classicForMethodPlus(List<Integer> list) {
        long startTime = System.nanoTime();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.printf("%d %d ", list.get(i), size);
        }
        long stopTime = System.nanoTime();
        long classicForMethodPlusTime = stopTime - startTime;
        System.out.println();
        return classicForMethodPlusTime;
    }

    private static long classicForMethodMinus(List<Integer> list) {
        long startTime = System.nanoTime();
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            System.out.printf("%d %d ",list.get(i), size);
        }
        long stopTime = System.nanoTime();
        long classicForMethodMinusTime = stopTime - startTime;
        System.out.println();
        return classicForMethodMinusTime;
    }

    private static long iteratorMethod(List<Integer> list) {
        long startTime = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.printf("%d ", iterator.next());
        }
        long stopTime = System.nanoTime();
        long iteratorMethodTime = stopTime - startTime;
        System.out.println();
        return iteratorMethodTime;
    }

    private static long iteratorMethodI(List<Integer> list) {
        long startTime = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.printf("%d %d ", iterator.next(), list.size());
        }
        long stopTime = System.nanoTime();
        long iteratorMethodITime = stopTime - startTime;
        System.out.println();
        return iteratorMethodITime;
    }

    private static long iteratorMethodPlus(List<Integer> list) {
        long startTime = System.nanoTime();
        int size = list.size();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.printf("%d %d ", iterator.next(), size);
        }
        long stopTime = System.nanoTime();
        long iteratorMethodPlusTime = stopTime - startTime;
        System.out.println();
        return iteratorMethodPlusTime;
    }

    private static long iteratorMethodMinus(List<Integer> list) {
        long startTime = System.nanoTime();
        int size = list.size();
        ListIterator<Integer> iterator = list.listIterator(size);
        while (iterator.hasPrevious()) {
            System.out.printf("%d %d ", iterator.previous(), size);
        }
        long stopTime = System.nanoTime();
        long iteratorMethodMinusTime = stopTime - startTime;
        System.out.println();
        return iteratorMethodMinusTime;
    }
}
