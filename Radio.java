public class Radio {

    int radio;
    public static int radioPower2;
    public static double area;
    public static double PI = 3.14;
    public static double radioPowerForArea;


    //se calcula radio al cuadrado
    static int calcRadioPowerOf2(int radio) {
        radioPower2 = radio*radio;
        radioPowerForArea = Double.valueOf(radioPower2);
        System.out.println("El área del círculo es " + circleArea(radioPowerForArea));
        return radioPower2;
    }

    static double circleArea(double radioPowerForArea){
        area = (PI * radioPowerForArea);
        return area;
    }

    public static void main (String[] args) {
        //calculando area de circulo de radio 4
        calcRadioPowerOf2(4);
    }   
}
