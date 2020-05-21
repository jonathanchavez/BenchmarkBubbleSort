import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class BenchmarkSorts {
    YourSort sort;
    int[] sizes;
    ArrayList<ArrayList<Hold>> Sets;

    BenchmarkSorts(int[] sizes){
        YourSort sort = new YourSort();
        this.sort = sort;
        this.sizes = sizes;
        runSorts();
        displayReports();


    }

    //temp benchmark for warm up
    BenchmarkSorts(int[] temp, int a){
        YourSort sort = new YourSort();
        this.sort = sort;
        sizes = temp;
        runSorts();
    }

    //runs the test
    void runSorts() {
        Sets = new ArrayList<ArrayList<Hold>>();

        //goes through the 10 different data sets
        for (int j = 0; j < 10; j++) {

            ArrayList<Hold> dataSet = new ArrayList<Hold>();
            //runs the set 50 times
            for (int i = 0; i < 50; i++) {



                Random rd = new Random(); // creating Random object
                int[] arr = new int[sizes[j]];
                //makes random number base on the data set
                for (int b = 0; b < arr.length; b++) {
                    arr[b] = rd.nextInt(1000);
                }
                //makes a second array
                int[] arr2 = arr.clone();

                //runs the recursive version and capture results
                Hold rec = new Hold();
                rec.setType(2);

                sort.recursiveSort(arr);

                rec.setCount(sort.getCount());
                rec.setTime(sort.getTime());

                dataSet.add(rec);

                //runs the iterative version and captures results
                Hold it = new Hold();
                it.setType(1);

                sort.iterativeSort(arr2);

                it.setCount(sort.getCount());
                it.setTime(sort.getTime());
                dataSet.add(it);


            }
            Sets.add(dataSet);


        }

    }

    void displayReports(){

        double averageRCount = 0;
        double averageICount = 0;

        long averageRTime = 0;
        long averageITime = 0;
        System.out.println();
        //prints out the header

        System.out.println(" Data \t\t\t\t\t\t\t\t\tIterative \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Recursive" +
                "\n Set\nSize n\n              Average            Coefficient of           Average             Coefficient of" +
                "             Average             Coefficient of            Average             Coefficient of\n              Critical           Variance of             Execution" +
                "              Variance of              Critical              Variance of             Execution            Variance of" +
                "" +
                "\n             Operation              Count                  Time                    Time                  Operation               Count" +
                "                  Time                    Time" +
                "\n               Count                                                                                      Count");

        ArrayList<Double> itcount = new ArrayList<Double>();
        ArrayList<Double> reccount = new ArrayList<Double>();
        ArrayList<Long> ittime = new ArrayList<Long>();
        ArrayList<Long> rectime = new ArrayList<Long>();

        //goes through the 10 different data set
        for (int i = 0; i < 10; i++){
            averageRCount = 0;
            averageICount = 0;

            averageRTime = 0;
            averageITime = 0;

            reccount = new ArrayList<Double>();
            itcount = new ArrayList<Double>();
            rectime = new ArrayList<Long>();
            ittime = new ArrayList<Long>();

            //goes through the results that it capture
            for (int j = 0; j < 100; j++){

                //recursive
                if (Sets.get(i).get(j).type == 2){
                    //adds all of the count and time from each run
                    averageRCount = averageRCount + Sets.get(i).get(j).count;
                    averageRTime = averageRTime + Sets.get(i).get(j).time;

                    //adds to new array the time for each data
                    reccount.add((double) Sets.get(i).get(j).count);
                    rectime.add(Sets.get(i).get(j).time);

                }
                //iterative
                else if (Sets.get(i).get(j).type == 1){
                    //adds all of the count and time from each run

                    averageICount = averageICount + Sets.get(i).get(j).count;
                    averageITime = averageITime + Sets.get(i).get(j).time;

                    //adds to new array the time for each data

                    itcount.add((double) Sets.get(i).get(j).count);
                    ittime.add(Sets.get(i).get(j).time);

                }
            }

            //Recursive

            //finds the average
            double RCmean = averageRCount / (double) reccount.size();
            double RTmean = averageRTime / (double) rectime.size();

            double squaredMean = 0;

            //find the standard deviation for count
            for (int b = 0; b < reccount.size(); b++){

                double temp = Math.pow( (reccount.get(b) - RCmean), 2);
                squaredMean = squaredMean + temp;
            }
            squaredMean = (1/(double) reccount.size()) * squaredMean;

            squaredMean = Math.sqrt(squaredMean);

            //coefficinet for count
            double recCountCo = (squaredMean/ RCmean) * 100;


            //find the standard devation for time
            double squaredMeanTime = 0;
            for (int b = 0; b < rectime.size(); b++){

                double temp = Math.pow( (rectime.get(b) - RTmean), 2);
                squaredMeanTime = squaredMeanTime + temp;
            }

            squaredMeanTime = (1/(double) rectime.size()) * squaredMeanTime;

            squaredMeanTime = Math.sqrt(squaredMeanTime);

            //coefficient for time
            double recTimeCo = (squaredMeanTime / RTmean) * 100;

            //iterative

            //gets the average
            double ICmean = averageICount / (double) itcount.size();
            double ITmean = averageITime / (double) ittime.size();

            double isquaredmean = 0;

            //find the standard deviation for count
            for (int b = 0; b < itcount.size(); b++){

                double temp = Math.pow( (itcount.get(b) - ICmean), 2);
                isquaredmean = isquaredmean + temp;
            }

            isquaredmean = (1/(double) itcount.size()) * isquaredmean;

            isquaredmean = Math.sqrt(isquaredmean);

            //coefficient for count
            double itCountCo = (isquaredmean/ICmean) * 100;

            //find the standard deviation for time

            double iTsquaredmean = 0;
            for (int b = 0; b < ittime.size(); b++){

                double temp = Math.pow( (ittime.get(b) - ITmean), 2);
                iTsquaredmean = iTsquaredmean + temp;
            }

            iTsquaredmean = (1/(double) ittime.size()) * iTsquaredmean;

            iTsquaredmean = Math.sqrt(iTsquaredmean);

            //coefficient for time
            double itTimeCo = (iTsquaredmean/ITmean) * 100;

            //prints out the results
            System.out.printf("%4d     %18.3f       %18.3f           %18.3f          %18.3f           %18.3f        %18.3f            %18.3f         %18.3f \n", sizes[i], ICmean, itCountCo, ITmean, itTimeCo, RCmean,recCountCo, RTmean, recTimeCo);


            //WAS AT 13.3f changed for higher nubmers



        }

    }

}

//class that holds the result for each run
class Hold {
    //defines the type recursive or iterative
    int type;
    //the amount of count
    int count;

    //the time of the run
    long time;

    void setCount(int a){
        count = a;
    }
    void setTime(long b){
        time = b;
    }

    void setType(int c) {
        type = c;
    }}