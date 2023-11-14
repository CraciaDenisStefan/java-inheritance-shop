package org.lessons.java.shop;

public class Televisori extends Prodotto {
    private int dimensioni;
    private boolean isSmart;

    public Televisori(String nome, String descrizione, double prezzo, double iva, int dimensioni, boolean isSmart) {
        super(nome, descrizione, prezzo, iva);
        setDimensioni(dimensioni);
        setSmart(isSmart);
    }

    public int getDimensioni() {
        return dimensioni;
    }

    public void setDimensioni(int dimensioni) {
        this.dimensioni = dimensioni;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

    @Override
    protected double calcolaScontoPersonalizzato() {
        if (!isSmart()) {
            return 0.10;
        }
        return 0.02;
    }
    @Override
    public String toString() {
        return super.toString() + "Dimensioni: " + getDimensioni() + " pollici\n" + "Smart: " + (isSmart() ? "si" : "no") + "\n";
    }
}
