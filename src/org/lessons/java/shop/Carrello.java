package org.lessons.java.shop;

import java.util.Scanner;

public class Carrello {
    private Prodotto[] prodotti;
    private int numeroProdotti;

    public Carrello() {
        prodotti = new Prodotto[5];
        setNumeroProdotti(0);
    }

    public void aggiungiProdotto(Prodotto prodotto, boolean haTesseraFedelta) {
        if (getNumeroProdotti() < prodotti.length) {
            prodotto.setHaTesseraFedelta(haTesseraFedelta);
            prodotti[getNumeroProdotti()] = prodotto;
            setNumeroProdotti(getNumeroProdotti() + 1);
        } else {
            System.out.println("Carrello pieno, impossibile aggiungere altri prodotti.");
        }
    }

    public int getNumeroProdotti() {
        return numeroProdotti;
    }

    private void setNumeroProdotti(int numeroProdotti) {
        this.numeroProdotti = numeroProdotti;
    }

    public void valorizzaCarrello() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Possiedi una tessera fedeltà? (si/no): ");
        String rispostaTessera = scanner.nextLine();
        boolean haTesseraFedelta = rispostaTessera.equalsIgnoreCase("si");

        boolean continua = true;
        boolean carrelloPieno = false;

        while (continua && !carrelloPieno) {
            if (getNumeroProdotti() < prodotti.length) {
                System.out.println("Inserisci il tipo di prodotto (Smartphone, Televisore, Cuffie): ");
                String tipoProdotto = scanner.nextLine();

                System.out.println("Inserisci il nome: ");
                String nome = scanner.nextLine();

                System.out.println("Inserisci la descrizione: ");
                String descrizione = scanner.nextLine();

                System.out.println("Inserisci il prezzo: ");
                double prezzo = scanner.nextDouble();

                System.out.println("Inserisci l'IVA: ");
                double iva = scanner.nextDouble();
                scanner.nextLine();

                if ("smartphone".equalsIgnoreCase(tipoProdotto)) {
                    System.out.println("Inserisci IMEI: ");
                    String imei = scanner.nextLine();
                    System.out.println("Inserisci quantità di memoria: ");
                    int memoria = scanner.nextInt();
                    scanner.nextLine();
                    aggiungiProdotto(new Smartphone(nome, descrizione, prezzo, iva, imei, memoria), haTesseraFedelta);

                } else if ("televisore".equalsIgnoreCase(tipoProdotto)) {
                    System.out.println("Inserisci dimensioni: ");
                    int dimensioni = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Il televisore è smart? (si/no)  ");
                    String rispostaSmart = scanner.nextLine();
                    boolean isSmart = rispostaSmart.equalsIgnoreCase("si");
                    aggiungiProdotto(new Televisori(nome, descrizione, prezzo, iva, dimensioni, isSmart), haTesseraFedelta);

                } else if ("cuffie".equalsIgnoreCase(tipoProdotto)) {
                    System.out.println("Inserisci colore: ");
                    String colore = scanner.nextLine();
                    System.out.println("Le cuffie sono wireless? (si/no) ");
                    String rispostaWireless = scanner.nextLine();
                    boolean isWireless = rispostaWireless.equalsIgnoreCase("si");
                    aggiungiProdotto(new Cuffie(nome, descrizione, prezzo, iva, colore, isWireless), haTesseraFedelta);

                } else {
                    System.out.println("Tipo di prodotto non valido.");
                }
            } else {
                System.out.println("Il carrello è pieno. Impossibile aggiungere altri prodotti.");
                carrelloPieno = true;
            }

            if (!carrelloPieno) {
                System.out.println("Vuoi inserire un altro prodotto? (si/no): ");
                String risposta = scanner.nextLine();
                continua = risposta.equalsIgnoreCase("si");
            }
        }

        scanner.close();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Carrello:\n");

        for (int i = 0; i < getNumeroProdotti(); i++) {
            result.append(prodotti[i].toString()).append("\n");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Carrello carrello = new Carrello();
        carrello.valorizzaCarrello();
        System.out.println(carrello.toString());
    }
}
