package com.ikuta.insertion;

import java.util.Arrays;

public class TestInsertion {
    public static void main(String[] args) {
        Integer[] arr = {4, 3, 2, 10, 12, 1, 5, 6};
        Insertion.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
