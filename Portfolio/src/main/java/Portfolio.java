import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Portfolio {

    //variables de objeto
    static ArrayList < Integer > stocks = new ArrayList < Integer > ();

    //llena 1 mes de stocks
    public void fillingStocks(int price) {
        stocks.add(price);
    }

    void randomInRange() {
        for (int i = 0; i < 31; i++) {
            double randomDouble = Math.random();
            randomDouble = randomDouble * 50 + 10000;
            int randomInteger = (int) randomDouble;
            fillingStocks(randomInteger);
            //            System.out.print("día " + i);
        }
        System.out.println(stocks);
    }

    void Price(ArrayList < Integer > stockForDates) {

        System.out.println("- - - - - - - - \nVamos a elegir un período de tiempo.  ");
        System.out.println("++++++++++\nIngresa un día del 1 al 30: ");
        Scanner input = new Scanner(System.in);
        int date_1_number = input.nextInt();
        //            if (date_1_number == 0 || date_1_number < 0) {
        //            System.out.println("++++++++++\nNo puede ser 0 ni menor. ");
        //        }    else {
        System.out.println("++++++++++\nIngresa otro día del 1 al 30: ");

        int date_2_number = input.nextInt();
        System.out.println("Este es el valor de tus stocks al " + (date_1_number) + " del mes actual: " + stockForDates.get(date_1_number - 1));
        System.out.println("Este es el valor de tus stocks al " + (date_2_number) + " del mes actual: " + stockForDates.get(date_2_number - 1));
        stockOperation(stockForDates.get(date_1_number - 1), stockForDates.get(date_2_number - 1));
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
        while(true) {
            Portfolio myPortfolio = new Portfolio();
            System.out.println("$*+*+*+*+* Welcome to my stonks *+*+*+*+*$\nAquí podrás ver lo que has perdido :( y ganado :) ");
            myPortfolio.randomInRange();
            myPortfolio.Price(stocks);
        }
    }
}