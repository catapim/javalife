import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Portfolio {

    //variables de objeto
    static ArrayList<Integer> stocks = new ArrayList<Integer>();

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
    public static int[] dic = new int[AMOUNT_DAYS_2];

    //fill 1 month of stocks
    public void fillingStocks(int price) {
        stocks.add(price);
    }

    //fill the stocks with random numbers between 10000 and 10900
    void randomRangeDailyStocks(int amountDays, int[] givenArray, String monthName_) {
        for (int i = 0; i < amountDays; i++) {
            double randomDouble = Math.random();
            randomDouble = randomDouble * 900 + 10000;
            int randomInteger = (int) randomDouble;
            givenArray[i] = randomInteger;
        }
        System.out.println("Tus stocks del mes de " + monthName_);
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
            System.out.println(simpleDateFormat.format(date_1_));
            System.out.println(simpleDateFormat.format(date_2_));
            //the date is separated MM-dd-yyyy (only month and day)
            splitDate(date_1, date_2);
        } catch (ParseException e) {
            System.out.println("Only dates in the indicated format! Don't break the matrix pls.");
        }
    }

    //method to separate dates
    void splitDate(String givenDate1_, String givenDate2_) throws ParseException {
        String[] splitDate1 = givenDate1_.split("-");
        String[] splitDate2 = givenDate2_.split("-");
        System.out.println(Arrays.toString(splitDate1));
        System.out.println(Arrays.toString(splitDate2));
        int[] getMonth1 = new int[31];
        int[] getMonth2 = new int[31];

        int setMonth1 = Integer.valueOf(splitDate1[0]);
        int setMonth2 = Integer.valueOf(splitDate2[0]);

        if (setMonth1 == 1) {
            getMonth1 = jan;
        } else if (setMonth1 == 2) {
            getMonth1 = feb;
        } else if (setMonth1 == 3) {
            getMonth1 = march;
        } else {
            System.out.println("tbd");
        }

        if (setMonth2 == 1) {
            getMonth2 = jan;
        } else if (setMonth2 == 2) {
            getMonth2 = feb;
        } else if (setMonth2 == 3) {
            getMonth2 = march;
        } else {
            System.out.println("tbd");
        }
        //0 == MM, 1==dd, 2== yyyy
        periodMonthOperation(setMonth1, setMonth2, Integer.valueOf(splitDate1[1]) - 1, Integer.valueOf(splitDate2[1]) - 1, getMonth1, getMonth2);
    }

    void periodMonthOperation(int getMonth_1, int getMonth_2, int getDay_1, int getDay_2, int[] givenArray_1, int[] givenArray_2) throws ParseException {
        System.out.printf("\nThis is your first value selected: " + Arrays.toString(new int[]{givenArray_1[getDay_1]}));
        System.out.println("\nThis is your second value selected: " + Arrays.toString(new int[]{givenArray_2[getDay_2]}));
        int resultado;
        if (getMonth_1 > getMonth_2) {
            resultado = givenArray_1[getDay_1] - givenArray_2[getDay_2];
            if (resultado > 0) {
                System.out.println("-------------------------------\nIn this period you earned: " + resultado);
            } else {
                System.out.println("-------------------------------\nIn this period you lost: " + resultado);
            }

        } else if (getMonth_1 == getMonth_2) {
            if (getDay_1 > getDay_2) {
                resultado = givenArray_1[getDay_1] - givenArray_2[getDay_2];
                if (resultado > 0) {
                    System.out.println("-------------------------------\nIn this period you earned: " + resultado);
                } else {
                    System.out.println("-------------------------------\nIn this period you lost: " + resultado);
                }
            }
        } else {

            resultado = givenArray_2[getDay_2] - givenArray_1[getDay_1];
            if (resultado > 0) {
                System.out.println("-------------------------------In this period you earned: " + resultado);
            } else {
                System.out.println("-------------------------------In this period you lost: " + resultado);
            }
        }
    }

//        void annualizedReturn ( int lastAmount, int firstAmount){
//            double performance = (lastAmount - firstAmount) / firstAmount;
//            double annReturn = (1 + performance) - 1;
//            //        System.out.println("Tu annualized return in this period is: " + annReturn);
//        }

        public static void main (String[]args) throws ParseException {

            Portfolio myPortfolio = new Portfolio();
            System.out.println("Cargando tus stonks...");
            myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_2, jan, "enero");
            myPortfolio.randomRangeDailyStocks(FEBRUARY_DAYS, feb, "febrero");
            myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_2, march, "marzo");
            myPortfolio.getUserDates();
        }
    }
