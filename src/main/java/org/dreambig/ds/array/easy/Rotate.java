package org.dreambig.ds.array.easy;

public class Rotate {

    public static void rotate(int arr[]) {
        int l = arr.length;
        for (int i = l - 1; i > 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int [] arr= {1,2,3,4,5};
        rotate(arr);
    }

}
