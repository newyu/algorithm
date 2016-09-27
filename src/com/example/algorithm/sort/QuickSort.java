package com.example.algorithm.sort;

public class QuickSort {

    private static int getMiddle(int[] a, int low, int high) {
        int tmp = a[low];

        while (low < high) {
            while (low < high && a[high] >= tmp) {
                high--;
            }
            a[low] = a[high];

            while (low < high && a[low] <= tmp) {
                low++;
            }
            a[high] = a[low];
        }

        a[low] = tmp;

        return low;
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }

    private static void quickSort(int[] a) {
        if (a.length > 0) {
            quickSort(a, 0, a.length - 1);
        }
    }

    private static void print(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("array is null or length is 0");
            return;
        }

        StringBuilder builder = new StringBuilder();

        for (int i : array) {
            if (builder.length() > 0) {
                builder.append(",");
            }
            builder.append(i);
        }

        System.out.println(builder.toString());
    }


    public static void main(String[] args) {
        int[] a = {3, 6, 9, 4, 8, 2, 0, 5, 7, 1};


        System.out.print("before order: ");
        print(a);

        quickSort(a);

        System.out.print("after  order: ");
        print(a);
    }

}
