package org.lessons.java.shop;

import java.util.Random;

public class Prodotto {
    private int codice;
    private String nome;
    private String descrizione;
    private double prezzo;
    private double iva;
    private boolean haTesseraFedelta;

    public Prodotto(String nome, String descrizione, double prezzo, double iva) {
        generateNewRandomCode();
        setNome(nome);
        setDescrizione(descrizione);
        setPrezzo(prezzo);
        setIva(iva);
    }

    private void generateNewRandomCode() {
        Random random = new Random();
        setCodice(random.nextInt(100000000));
    }

    public long getCodice() {
        return codice;
    }

    private void setCodice(int codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPrezzoConIva() {
        return prezzo * (1 + iva / 100);
    }

    public String getNomeEsteso() {
        return codice + "-" + nome;
    }

    public void setHaTesseraFedelta(boolean haTesseraFedelta) {
        this.haTesseraFedelta = haTesseraFedelta;
    }

    private String addZeroCodice() {
        String codiceStr = String.valueOf(codice);
        int lunghezzaCodice = codiceStr.length();

        if (lunghezzaCodice < 8) {
            int zeriDaAggiungere = 8 - lunghezzaCodice;
            StringBuilder codiceConPad = new StringBuilder();

            for (int i = 0; i < zeriDaAggiungere; i++) {
                codiceConPad.append("0");
            }

            codiceConPad.append(codiceStr);
            return codiceConPad.toString();
        }

        return codiceStr;
    }

    public double prezzoScontato() {
        double scontoBase = 0.02;

        if (haTesseraFedelta) {
            double scontoPersonalizzato = calcolaScontoPersonalizzato();
            return getPrezzoConIva() * (1 - scontoPersonalizzato);
        }

        return getPrezzoConIva() * (1 - scontoBase);
    }

    protected double calcolaScontoPersonalizzato() {
        return 0.0;
    }
   
    public boolean haTesseraFedelta() {
        return haTesseraFedelta;
    }
    @Override
    public String toString() {
        return "Prodotto:\n" +
                "Codice: " + getCodice() + "\n" +
                "Nome: " + getNome() + "\n" +
                "Descrizione: " + getDescrizione() + "\n" +
                "Prezzo: " + getPrezzo() + " EUR\n" +
                "IVA: " + getIva() + "%\n" +
                "Prezzo con IVA: " + getPrezzoConIva() + " EUR\n" +
                "Nome Esteso: " + getNomeEsteso() + "\n" +
                "Codice con pad: " + addZeroCodice() + "\n" +
                "Prezzo scontato: " + (haTesseraFedelta() ? prezzoScontato() : "Nessun sconto") + "\n";
    }
}

