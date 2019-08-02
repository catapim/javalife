import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.math.BigDecimal;

public class Portfolio {

    //variables de objeto
    static int AMOUNT_DAYS_1 = 30;
    static int AMOUNT_DAYS_2 = 31;
    static int FEBRUARY_DAYS = 29;
    public static int[] jan = new int[AMOUNT_DAYS_2];
    public static int[] feb = new int[FEBRUARY_DAYS];
    public static int[] march = new int[AMOUNT_DAYS_2];
    public static int[] apr = new int[AMOUNT_DAYS_1];
    public static int[] may = new int[AMOUNT_DAYS_2];
    public static int[] jun = new int[AMOUNT_DAYS_1];
    public static int[] jul = new int[AMOUNT_DAYS_2];
    public static int[] aug = new int[AMOUNT_DAYS_2];
    public static int[] sep = new int[AMOUNT_DAYS_1];
    public static int[] oct = new int[AMOUNT_DAYS_2];
    public static int[] nov = new int[AMOUNT_DAYS_1];
    public static int[] dec = new int[AMOUNT_DAYS_2];

    //fill the stocks with random numbers between 10000 and 10900
    void randomRangeDailyStocks(int amountDays, int[] givenArray, String monthName_) {
        for (int i = 0; i < amountDays; i++) {
            double randomDouble = Math.random();
            randomDouble = randomDouble * 900 + 10000;
            int randomInteger = (int) randomDouble;
            givenArray[i] = randomInteger;
        }
        System.out.println("These are your latest stocks: " + monthName_);
        System.out.println(Arrays.toString(givenArray));
    }

    //asks for 2 dates, to get a period of time.
    void getUserDates() throws ParseException {
        Scanner input = new Scanner(System.in);
        String pattern = "MM-dd-yyyy";

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            System.out.println("-------------------------------\nLet's choose a period of time, between 2 dates. ");
            System.out.println("-------------------------------\nPls write a date in this format: 'MM-dd-yyyy': ");
            String date_1 = input.nextLine();
            System.out.println("-------------------------------\nPls write a second in the same format: 'MM-dd-yyyy': ");
            String date_2 = input.nextLine();

            Date date_1_ = simpleDateFormat.parse(date_1);
            Date date_2_ = simpleDateFormat.parse(date_2);
            //printing the formatted dates
            System.out.println("These are your dates: ");
            System.out.println(simpleDateFormat.format(date_1_));
            System.out.println(simpleDateFormat.format(date_2_));
            //the date is separated MM-dd-yyyy (only month and day)
            splitDate(date_1,date_2,date_1_,date_2_);

        } catch (ParseException e) {
            System.out.println("Only dates in the indicated format! Don't break the matrix pls.");
        }
    }

    //method to separate dates
    long splitDate(String givenDate1_, String givenDate2_, Date date_1, Date date_2) throws ParseException {

        long betweenDays = ChronoUnit.DAYS.between(date_1.toInstant(), date_2.toInstant());

        String[] splitDate1 = givenDate1_.split("-");
        String[] splitDate2 = givenDate2_.split("-");
//        System.out.println(Arrays.toString(splitDate1));
//        System.out.println(Arrays.toString(splitDate2));
        //0 == MM, 1==dd, 2== yyyy
        int[] getMonth1;
        int[] getMonth2;

        int setMonth1 = Integer.valueOf(splitDate1[0]);
        int setMonth2 = Integer.valueOf(splitDate2[0]);

        if (setMonth1 == 1) {
            getMonth1 = jan;
        } else if (setMonth1 == 2) {
            getMonth1 = feb;
        } else if (setMonth1 == 3) {
            getMonth1 = march;
        } else if (setMonth1 == 4) {
            getMonth1 = apr;
        } else if (setMonth1 == 5) {
            getMonth1 = may;
        } else if (setMonth1 == 6) {
            getMonth1 = jun;
        } else if (setMonth1 == 7) {
            getMonth1 = jul;
        } else if (setMonth1 == 8) {
            getMonth1 = aug;
        } else if (setMonth1 == 9) {
            getMonth1 = sep;
        } else if (setMonth1 == 10) {
            getMonth1 = oct;
        } else if (setMonth1 == 11) {
            getMonth1 = nov;
        } else {
            getMonth1 = dec;
        }

        if (setMonth2 == 1) {
            getMonth2 = jan;
        } else if (setMonth2 == 2) {
            getMonth2 = feb;
        } else if (setMonth2 == 3) {
            getMonth2 = march;
        } else if (setMonth2 == 4) {
            getMonth2 = apr;
        } else if (setMonth2 == 5) {
            getMonth2 = may;
        } else if (setMonth2 == 6) {
            getMonth2 = jun;
        } else if (setMonth2 == 7) {
            getMonth2 = jul;
        } else if (setMonth2 == 8) {
            getMonth2 = aug;
        } else if (setMonth2 == 9) {
            getMonth2 = sep;
        } else if (setMonth2 == 10) {
            getMonth2 = oct;
        } else if (setMonth2 == 11) {
            getMonth2 = nov;
        } else {
            getMonth2 = dec;
        }
        double profit_ = profit( Integer.valueOf(splitDate1[1])-1, Integer.valueOf(splitDate2[1])-1, getMonth1, getMonth2);
        annualizedR(betweenDays,Integer.valueOf(splitDate1[1])-1,Integer.valueOf(splitDate2[1])-1,getMonth1,getMonth2);
        return betweenDays;
    }


    double profit(int getDay_1, int getDay_2, int[] givenArray_1, int[] givenArray_2){
        int lastValue = givenArray_2[getDay_2];
        int firstValue = givenArray_1[getDay_1];
        double profit_ = (Double.valueOf(lastValue)-Double.valueOf(firstValue))/Double.valueOf(firstValue);
        return profit_;
    }

    public PrintStream annualizedR(long amountOfDays, int getDay_1, int getDay_2, int[] givenArray_1, int[] givenArray_2) throws ParseException {
        System.out.printf("\nThis is your first value selected: " + Arrays.toString(new int[] {givenArray_1[getDay_1]}));
        System.out.println("\nThis is your second value selected: " + Arrays.toString(new int[] {givenArray_2[getDay_2]}));
        long daysBetween = amountOfDays;
        int AVG_DAYS_MONTH = 30;
        double profit = profit(getDay_1,getDay_2,givenArray_1,givenArray_2);
        if (profit > 0) {
            System.out.printf("In this period you earned:%.3f%%%n", profit);
        } else {
            System.out.printf("In this period you lost:%.3f%%%n", profit);
        }
        double daysToMonths = Double.valueOf(daysBetween) / Double.valueOf(AVG_DAYS_MONTH);
        double monthsDecimal = (daysToMonths*AVG_DAYS_MONTH)/365;
        double annualReturn = ((Math.pow(1+profit,(1/monthsDecimal))) - 1 );

        System.out.println("This is the amount of days between those dates: " + daysBetween);
        System.out.printf("Those days are equivalent to %.2f years. \n", monthsDecimal);
        System.out.printf("Or the equivalent to to %.2f months if we use %d as an average of days per month. \n", daysToMonths,AVG_DAYS_MONTH);
        return System.out.printf("This is your annualized return: %.3f%%%n", annualReturn);
    }

    public static void main(String[] args) throws ParseException {
        Portfolio myPortfolio = new Portfolio();
        System.out.println("Cargando tus stonks...");
        myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_2, jan, "January");
        myPortfolio.randomRangeDailyStocks(FEBRUARY_DAYS, feb, "February");
        myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_2, march, "March");
        myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_1, apr, "April");
        myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_2, may, "May");
        myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_1, jun, "Jun");
        myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_2, jul, "July");
        myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_2, aug, "August");
        myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_1, sep, "September");
        myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_2, oct, "October");
        myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_1, nov, "November");
        myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_2, dec, "December");
        myPortfolio.getUserDates();
    }
}