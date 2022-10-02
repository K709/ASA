/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asa_kelompok;

import java.util.Arrays;

/**
 *
 * @author Lenovo
 */
public class sequentialSearch {
        protected int hitung;
    public int sequentialSearch(int[] data, int kunci){

        for(int counter = 0;counter<data.length;counter++){
          
            hitung = data[counter];
            if(data[counter]==kunci)
                return counter;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        sequentialSearch search = new sequentialSearch();
        
        int max = 100000000;
        int min = 1;
        int range = max - min + 1; 
        int[] array = new int[100000000];
       
        
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*range)+min;
        }
        //Arrays.sort(array); //kalau di sortir maka akan membutuhkan waktu yang banyak
        System.out.println(search.sequentialSearch(array, 5000000));
    }
    }

