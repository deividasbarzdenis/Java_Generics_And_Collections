package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        getBankont(170);
    }

    public static void getBankont(int sum) {
        int laikinas = sum / 100;
        if (laikinas % 100 >= 1) {
            System.out.println("100: " + laikinas + "pcs");
            sum -= 100 * laikinas;
        }
        laikinas = sum / 50;
        if (laikinas % 50 >= 1) {
            System.out.println("50: " + laikinas + "pcs");
            sum -= 50 * laikinas;
        }
        laikinas = sum / 20;
        if (laikinas % 20 >= 1) {
            System.out.println("20: " + laikinas + "pcs");
            sum -= 20 * laikinas;
        }
    }
}
