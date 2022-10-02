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
public class binarySearch {
    protected int hitung;
    
    public int binarySearch(int[] data, int kunci){
        int indeksAkhir = data.length-1;

        for(int indeksAwal = 0; indeksAwal <= indeksAkhir;){
           
            int indeksTengah = (indeksAwal+indeksAkhir)/2;
            if(data[indeksTengah] == kunci)
                return indeksTengah;
            else if(data[indeksTengah]>kunci)
                indeksAkhir = indeksTengah-1;
            else
                indeksAwal = indeksTengah+1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        binarySearch search = new binarySearch();
        
        int max = 100000000;
        int min = 1;
        int range = max - min + 1; 
        int[] array = new int[100000000];
       
        
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*range)+min;
        }
        Arrays.sort(array);
        System.out.println(search.binarySearch(array, 5000000));
    }
    
}
