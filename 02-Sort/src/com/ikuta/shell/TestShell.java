package com.ikuta.shell;

import java.util.Arrays;

public class TestShell {
    public static void main(String[] args) {
        Integer[] arr = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        Shell.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
