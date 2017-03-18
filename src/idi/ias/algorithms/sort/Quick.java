package idi.ias.algorithms.sort;

import java.util.Random;

/**
 * Created by IAS on 2017/3/18.
 */
public class Quick {
    public static void sort(Integer[] a){
        sort(a, 0, a.length-1);
    }
    public static void sort(Integer[] a, int lo, int hi){
        if (hi <= lo) return;
        int i = partition(a, lo, hi);
        sort(a, lo, i-1);
        sort(a, i+1, hi);
    }
    private static int partition(Integer[] a, int lo, int hi){
        int v = a[lo];
        int i = lo;
        int j = hi+1;
        while (true){
            while (a[++i] < v){
                if (i == hi) break;
            }
            while (a[--j] > v){
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    private static void exch(Integer[] a, int m, int n){
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }
    private void show(Integer[] a){
        for (int b : a)
            System.out.print(b + " ");
        System.out.println();
    }

    public static void main(String[] args){
        Integer[] a = {3,4,1,6,8,4,123,54,3,44,432,66,33,44,55,77,56,666,434};
        Quick test = new Quick();
        test.show(a);
        test.sort(a);
        test.show(a);
    }


}
