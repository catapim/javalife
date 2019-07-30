import java.lang.Math.*;

public class RadioMethod {

    public static int radio;
    public static double radioPower2;
    public static double area;

    static double circleArea(double radio) {
        radioPower2 = radio*radio;
        area = radioPower2*Math.PI;
        return area;
    }

    public static void main (String[] args) {
        //calculando area de circulo de radio 4
        circleArea(4);
        System.out.println("Area de circulo es " + circleArea(4));

    }   
}
