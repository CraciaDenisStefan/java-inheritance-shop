package org.lessons.java.shop;

public class Cuffie extends Prodotto {
	
	private String colore;
    private boolean isWireless;

    public Cuffie(String nome, String descrizione, double prezzo, double iva, String colore, boolean isWireless) {
        super(nome, descrizione, prezzo, iva);
        setColore(colore);
        setWireless(isWireless);
      
    }

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public boolean isWireless() {
		return isWireless;
	}

	public void setWireless(boolean isWireless) {
		this.isWireless = isWireless;
	}
	
	@Override
    public String toString() {
        return super.toString() + "Colore: " + getColore() + "\n" + "Wireless: " + (isWireless() ? "si" : "no") + "\n";
    }
    
}
