package com.sda.CountingSort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        int [] tablica = {0,3,2,3,3,0,5,2,3};

        int max = 0;

        // wypełniamy tablice losowymi liczbami i sprawdzamy max wartosc w tablicy
        // na tej podstawie ustalimy rozmiar tablicy count
        for (int i=0; i<tablica.length; i++) {
            //tablica[i] = random.nextInt(10);
            if (tablica[i] > max) max = tablica[i];
        }
        System.out.println("max = " + max);

        int [] count = new int [max+1];
        for (int i=0; i<count.length; i++) count[i] = 0;
        System.out.println(Arrays.toString(tablica));

        for (int k=0; k<tablica.length; k++) count[tablica[k]] = count[tablica[k]] + 1;
        System.out.println(Arrays.toString(count));

        // tablica z sumowaniem
        int [] countBis = new int [max+1];

        countBis[0] = count[0];
        for (int i=1; i<countBis.length; i++) countBis[i] = countBis[i-1] + count[i];
        System.out.println(Arrays.toString(countBis));

        int [] result = new int [tablica.length];
        for (int i=tablica.length; i>0; i--) {
            result[countBis[tablica[i-1]]-1] = tablica[i-1];
            countBis[tablica[i-1]]--;
        }
        System.out.println(Arrays.toString(result));

    }
}
