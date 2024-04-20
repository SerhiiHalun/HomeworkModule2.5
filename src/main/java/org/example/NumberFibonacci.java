package org.example;

import java.util.HashMap;
import java.util.Map;

public class NumberFibonacci {
    private static Map<Integer, Long> memo = new HashMap<>();

    //time complexity: O(n), spatial complexity:O(n).
    public static int recursiveNumberSearch(int n) {
        if (n <= 1) {
            return n;
        }

        return recursiveNumberSearch(n - 1) + recursiveNumberSearch(n - 2);
    }

    //time complexity: O(n), spatial complexity: O(n).
    public static long dynamicNumberSearch(int n) {
        if (n <= 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long fib = dynamicNumberSearch(n - 1) + dynamicNumberSearch(n - 2);
        memo.put(n, fib);
        return fib;
    }

    //time complexity: O(2^n), spatial complexity: O(1)
    public static int iterativeNumberSearch(int n) {
        int leftNumber = 0, rightNamber = 1, helpNumber;

        if (n <= 1) {
            return n;
        }
        for (int i = 2; i <= n; i++) {
            helpNumber = leftNumber + rightNamber;
            leftNumber = rightNamber;
            rightNamber = helpNumber;
        }
        return rightNamber;
    }
}
