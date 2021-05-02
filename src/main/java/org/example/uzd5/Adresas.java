package org.example.uzd5;

public class Adresas {
    private Miestas miestas;

    public Adresas() {
       miestas = new Miestas();
    }

    public String getMiestas() {
        return miestas.getPavadinimas();
    }

    public void setMiestas(String pavadinmas) {
        miestas.setPavadinimas(pavadinmas);
    }

}
