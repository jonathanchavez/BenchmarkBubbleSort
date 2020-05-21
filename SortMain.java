//Jonathan Chavez
//Project 1
//Nov 17 2017
//Benchmarking bubble sort


public class SortMain {

    public static void main(String[] args) {

        //warm up the jvm, by adding in a for loop through the benchmark
        int[] temps = {10, 10 ,10 ,10 ,10 ,10 ,10 ,10 ,10 ,10};
        for (int i = 0; i < 100000; i++) {
            BenchmarkSorts temp = new BenchmarkSorts(temps, 1);
        }



        int[] sizes = {100, 500, 1000, 5000, 10000, 15000, 20000, 25000, 30000, 35000};



        BenchmarkSorts bench = new BenchmarkSorts(sizes);





    }





}
