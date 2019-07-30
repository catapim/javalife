import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    ArrayList<Int> stocks = new ArrayList<Int>();


    Profit(){
    }

    public void setDate_0(int date1){

    }
    public void setDate_1(int date2){
        
    }

    public int getDates (int date1, int date2){
        System.out.println(date2-date1);
        return date2-date1;
    }

    // public profit(int date_0, int date_1) {
    //     int earning = (this.date_1-this.date_0);
    //     return this.earning;
    // }
    public static void main(String []args) {

        Portfolio myPortfolio = new Portfolio();
        myPortfolio.setDate_0(3);
        myPortfolio.setDate_1(1);
        System.out.println("hola");
        myPortfolio.getDates(4,3);
        // myPortfolio.profit(myPortfolio.first_date,myPortfolio.second_date);
    }
}