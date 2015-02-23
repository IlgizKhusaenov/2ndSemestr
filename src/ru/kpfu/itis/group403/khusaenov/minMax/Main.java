package ru.kpfu.itis.group403.khusaenov.minMax;

import java.util.Scanner;
public class Main {

    public static int [] searchMinMax(int[] a, int firstElement, int lastElement){

        int [] minMax = new int [2];

        if(lastElement-firstElement == 1) {
            if (a[lastElement] < a[firstElement]) {
                minMax[0] = a[lastElement];
                minMax[1] = a[firstElement];
            } else {
                minMax[0] = a[firstElement];
                minMax[1] = a[lastElement];
            }
            return minMax;
        }
        else {
            int[] right = searchMinMax(a, firstElement, (lastElement + firstElement) / 2);
            int[] left = searchMinMax(a, (lastElement + firstElement) / 2, lastElement);
            return new int[]{Math.min(right[0], left[0]),Math.max(right[1], left[1])};
        }

    }

    private static int[] searchMinMax(int[] a){
        return  searchMinMax(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Massive length (not less then 2):");
        int size = scan.nextInt();
        int [] array = new int [size];
        System.out.println("Massive elements: ");
        for (int i = 0; i <size; i++) {
            array[i]=scan.nextInt();
        }

        System.out.println("Max: "+ searchMinMax(array)[1]+", Min: "+ searchMinMax(array)[0]);

    }

}
