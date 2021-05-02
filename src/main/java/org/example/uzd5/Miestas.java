package org.example.uzd5;

public class Miestas {

    private String pavadinimas;

    private  Adresas adresas;

    public Miestas() {
    }

    public Miestas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    @Override
    public String toString() {
        return "Miestas{" +
                "pavadinimas='" + pavadinimas + '\'' +
                '}';
    }
}
