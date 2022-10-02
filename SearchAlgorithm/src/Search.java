import java.util.Arrays;

public class Search{

    protected int hitung;

    /*Sequential Search :

    Contoh :
    Pencarian 4 pada 1,2,3,4 :

    Perulangan 1 :
    1|2, 3, 4
    Tidak ditemukan, tambahkan indeks perulangan
    Perulangan 2:
    1, 2| 3, 4
    Tidak ditemukan, tambahkan indeks perulangan
    Perulangan 3 :
    1, 2, 3| 4
    Tidak ditemukan, tambahkan indeks perulangan
    Perulangan 4 :
    1, 2, 3, 4|
    Ditemukan, tambahkan indeks perulangan

    Berdasarkan contoh tersebut, ditemukan bahwa angka 4 ditemukan pada indeks terakhir.
    Jumlah perulangan yang dilakukan untuk mencapai array berukuran 4 adalah 4 kali,
    sehingga dapat disimpulkan bahwa jumlah perulangan yang memungkinkan dari algoritma tersebut adalah

    T(n) = 1 jika n = 1
    T(n) = T(n-1) + 1 jika n > 1

    Berdasarkan T(n) tersebut, didapatkan pula worst-case dari algoritma sequential, yakni O(n) 
    */

    public int sequentialSearch(int[] data, int kunci){

    for(int counter = 0;counter<data.length;counter++){
        hitung = data[counter];
        if(data[counter]==kunci)
            return counter;
        }
        return -1;
    }
    
    /*Binary Search :
     * Perulangan 1 : Panjang array (n)
     * Perulangan 2 : Panjang array (n/2)
     * Perulangan 3 : Panjang array (n/(2x2) = n/4)
     * Perulangan 4 : Panjang array (n/(2x2x2) = n/8)
     * ...........
     * Perulangan k : Panjang array (1)
     * 
     * Contoh :
     * Pencarian 2 dari 1, 2, 3, 4:
     * Perulangan 1 : 
     * 1, 2 | 3, 4
     * Tidak menemukan nilai 2, lakukan pencarian pada array berukuran 2 (hasil dari 4/2) dari indeks kiri:
     * Perulangan 2 :
     * 1 | 2
     * Tidak menemukan nilai 2, lakukan pencarian pada array berukuran 1 (hasil dari 2/2) dari indeks kanan:
     * Perulangan 3 :
     * 2
     * Menemukan nilai 2
     * 
     * Pada setiap perulangan array akan dibagi sebesar 1/2 dari array sebelumnya.
     * Jika array sebelumnya adalah n, maka array berikutnya adalah n/2.
     * Berdasarkan contoh diatas,
     * Ditemukan bahwa hasil dari pencarian pada array berukuran 4 diperlukan maksimal hingga 3 kali perulangan
     * 
     * Dengan demikian, dapat disimpulkan rumus dari T(n) adalah
     * Ketika n = 1, maka T(n) = 1
     * Ketika n > 1, maka T(n) = T(n/2) + 1
     * 
     * Jumlah panjang array per perulangan = n/(2^k)
     * 
     * Pada perulangan terakhir, jumlah array yang tersisa selalu bernilai 1
     * Sehingga, jika n/2^k = 1, maka n = 2^k
     * Dengan perhitungan Logaritma, didapatkan :
     * log(n) = log(2^k)
     * log(n) = k log(2)
     * log(n) = k
     * 
     * Sehingga didapatkan kompleksitas algoritma Binary Search sebesar log(n)
     */
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
        Search search = new Search();
        
        int max = 100000000;
        int min = 1;
        int range = max - min + 1; 
        int[] array = new int[100000000];
        int loop = 0;
        do{
            for (int i = 0; i < array.length; i++) {
                array[i] = (int)(Math.random()*range)+min;
            }

            double startTime = System.currentTimeMillis();
            System.out.println("Hasil Sequential Search ke "+(loop+1)+": "+search.sequentialSearch(array, 5000000));
            double endTime = System.currentTimeMillis();

            System.out.println("Waktu yang diperlukan :"+(endTime - startTime) + " Milidetik");

            Arrays.sort(array);

            startTime = System.currentTimeMillis();
            System.out.println("Hasil Binary Search "+(loop+1)+": "+search.binarySearch(array, 5000000));
            endTime = System.currentTimeMillis();

            System.out.println("Waktu yang diperlukan :"+(endTime - startTime)+" Milidetik");

            System.out.println("---------------------------------------\n");
        }while(loop++<10);
    }
}

