package com.hang.aopxml;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;

/**
 * Created by clark on 17/8/15.
 */
public class TestCalculate {

    public static void main(String[] args) {
        Integer[] ints = new Integer[2];

        String s = "";
        Scanner scanner = new Scanner(System.in);
        for (int count = 0; count < 2; count++) {
            ints[count] = scanner.nextInt();
            s = scanner.nextLine();
        }

        System.out.println(Arrays.toString(ints));

        calculateMN(ints);

        statics(s);

    }

    private static void statics(String s) {


    }

    private static void calculateMN(Integer[] ints) {
        List<Integer> primes = Arrays.asList(ints);
        IntSummaryStatistics stats = primes.stream().mapToInt((m) -> m).summaryStatistics();
        for (int i = stats.getMin(); i > 0; i--) {
            if (ints[0] % i == 0 && ints[1] % i == 0) {
                System.out.println("最大公约数：" + i);
                System.out.println("最小公倍数：" + ints[0]*ints[1]/i);
                break;
            }
        }
    }
}