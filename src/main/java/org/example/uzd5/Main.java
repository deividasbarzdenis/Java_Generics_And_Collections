package org.example.uzd5;

public class Main {

    public static void main(String[] args) {
        Adresas adresas = new Adresas();
        adresas.setMiestas("Vilnius");
        System.out.println(gautiMiestoPavadinima(adresas));
    }

    private static String gautiMiestoPavadinima(Adresas address){
       return address.getMiestas();
    }

}
