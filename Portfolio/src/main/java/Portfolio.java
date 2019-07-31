import java.lang.reflect.Array;
import java.util.*;

public class Portfolio {

    //variables de objeto
    static ArrayList < Integer > stocks = new ArrayList < Integer > ();

    static ArrayList < ArrayList > year = new ArrayList <ArrayList> ();

    static int AMOUNT_DAYS_1=30;
    static int AMOUNT_DAYS_2=31;
    static int FEBRUARY_DAYS=29;
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


    //llena 1 mes de stocks
    public void fillingStocks(int price) {
        stocks.add(price);
    }

    void randomInRange() {
        for (int i = 0; i < 31; i++) {
            double randomDouble = Math.random();
            randomDouble = randomDouble * 900 + 10000;
            int randomInteger = (int) randomDouble;
            fillingStocks(randomInteger);
        }
        System.out.println(stocks);
    }

    //se llena los array correspondientes a cada mes con valores random y se imprimen
    void randomRangeDailyStocks(int amountDays, int[] givenArray, String monthName_){
            for (int i = 0; i < amountDays; i++) {
                double randomDouble = Math.random();
                randomDouble = randomDouble * 900 + 10000;
                int randomInteger = (int) randomDouble;
                givenArray[i]=randomInteger;
            }
            System.out.println("Tus stocks del mes de " + monthName_);
            System.out.println( Arrays.toString(givenArray));
    }

    void getUserPeriodTime(){
        System.out.println("- - - - - - - - \nVamos a elegir un período de tiempo.  ");
        System.out.println("- - - - - - - - \nIndica un mes en formato MM. Eneros seria 01");
        Scanner input = new Scanner(System.in);
        int monthInput_1 = input.nextInt();
        System.out.println("- - - - - - - - \nIndica un día del mes del 1 al 30");
        int dayInput_1 = input.nextInt();
        System.out.println("- - - - - - - - \nIndica otro mes en formato MM");
        int monthInput_2 = input.nextInt();
        System.out.println("- - - - - - - - \nIndica un día del mes del 1 al 30");
        int dayInput_2 = input.nextInt();

        int[] monthArray_1 = new int[31];
        if (monthInput_1 == 1) {
            monthArray_1 = jan;
        } else if (monthInput_1 == 2) {
            monthArray_1 = feb;
        } else if (monthInput_1 == 3) {
            monthArray_1 = march;
        }
        int[] monthArray_2 = new int[31];
        if (monthInput_2 == 1) {
            monthArray_2 = jan;
        } else if (monthInput_2 == 2) {
            monthArray_2 = feb;
        } else if (monthInput_2 == 3) {
            monthArray_2 = march;
        }

        periodMonthOperation(monthInput_1,dayInput_1,monthInput_2,dayInput_2,monthArray_1,monthArray_2);
    }

    void periodMonthOperation(int getMonth_1, int getMonth_2, int getDay_1, int getDay_2, int[] givenArray_1, int[]givenArray_2){
        int resultado;
        if (getMonth_1 > getMonth_2) {
            resultado = givenArray_1[getDay_1-1] - givenArray_2[getDay_2-1];
            if (resultado > 0) {
                System.out.println("Esta es tu ganancia: " + resultado);
            } else {
                System.out.println("En este periodo perdiste: " + resultado);
            }
        } else {
            resultado = givenArray_2[getDay_2-1] - givenArray_1[getDay_1-1];
            if (resultado > 0) {
                System.out.println("Esta es tu ganancia: " + resultado);
            } else {
                System.out.println("En este periodo perdiste: " + resultado);
            }
        }
    }

    void annualizedReturn(int lastAmount, int firstAmount) {
        double performance = (lastAmount-firstAmount)/firstAmount;
        double annReturn = (1+performance)-1;
//        System.out.println("Tu annualized return in this period is: " + annReturn);
    }


    void price1(ArrayList < Integer > stockForDates) {
        System.out.println("- - - - - - - - \nVamos a elegir un período de tiempo.  ");
        System.out.println("++++++++++\nIngresa un día del 1 al 30: ");
        try {
            Scanner input = new Scanner(System.in);
            int date_1_number = input.nextInt();
            if (date_1_number > 0 || date_1_number != 0) {
                System.out.println("++++++++++\nIngresa otro día del 1 al 30: ");
                int date_2_number = input.nextInt();
                System.out.println("Este es el valor de tus stocks al " + (date_1_number) + " del mes actual: " + stockForDates.get(date_1_number - 1));
                System.out.println("Este es el valor de tus stocks al " + (date_2_number) + " del mes actual: " + stockForDates.get(date_2_number - 1));
                stockOperation(stockForDates.get(date_1_number - 1), stockForDates.get(date_2_number - 1));
            } else {
                System.out.println("Sólo ingresa numeros entre 1 y 30");
            }
        } catch (InputMismatchException e) {
            System.out.println("Sólo números del 1 al 30!");
        }
    }

    void stockOperation(int date_1_, int date_2_) {
        if (date_1_ > date_2_) {
            int resultado = date_1_ - date_2_;
            if (resultado > 0) {
                System.out.println("Esta es tu ganancia: " + resultado);
            } else {
                System.out.println("En este periodo perdiste: " + resultado);
            }
        } else {
            int resultado = date_2_ - date_1_;
            if (resultado > 0) {
                System.out.println("Esta es tu ganancia: " + resultado);
            } else {
                System.out.println("En este periodo perdiste: " + resultado);
            }
        }
    }

    public static void main(String[] args) {

            Portfolio myPortfolio = new Portfolio();
            System.out.println("Cargando tus stonks...");
            myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_2,jan,"enero");
            myPortfolio.randomRangeDailyStocks(FEBRUARY_DAYS,feb, "febrero");
            myPortfolio.randomRangeDailyStocks(AMOUNT_DAYS_2,march, "marzo");
            myPortfolio.getUserPeriodTime();






    }
}