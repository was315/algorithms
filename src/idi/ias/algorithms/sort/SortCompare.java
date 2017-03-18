package idi.ias.algorithms.sort;

import java.util.Random;

/**
 * Created by IAS on 2017/2/26.
 */
public class SortCompare {
    private static double time(String method, Comparable[] a){
        long times = System.currentTimeMillis();
        switch (method){
            case "Select": Select.sort(a);break;
            case "Insert": Insert.sort(a);break;
            case "InsertMove": Insert.sortMove(a);break;
            case "Shell": Shell.sort(a);break;
            case "Quick": Quick.sort((Integer[]) a);break;
            default: System.out.println("Warn: no method");
        }
        return System.currentTimeMillis() - times;
    }

    public static long test(String method, int L, int T){
        Random random = new Random();
        long total = 0;
        Integer[] a = new Integer[L];
        for (int t = 0; t < T; t++){
            for (int i = 0; i < L; i++)
                a[i] = random.nextInt();
            total += time(method, a);
        }
        return total;
    }
    public static void main(String[] args){
        System.out.println("Select:"+test("Select", 2000,10)+"ms");
        System.out.println("Insert:"+test("Insert", 2000,10)+"ms");
        System.out.println("InsertMove:"+test("InsertMove", 2000,10)+"ms");
        System.out.println("Shell:"+test("Shell", 2000,10)+"ms");
        System.out.println("Quick:"+test("Quick", 2000,10)+"ms");
    }
}
