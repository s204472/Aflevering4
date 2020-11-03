/*
 * Object representing an artikel
 */
public class Artikel {
	private String[] forfattere;
	private String titel;
	private Tidsskrift tidsskrift;
	private Artikel[] referenceliste;
	
	//Constructor setting forfatter titel og tidsskrift.
	public Artikel(String[] forfattere, String titel, Tidsskrift tidsskrift) {
		this.forfattere = forfattere;
		this.titel = titel;
		this.tidsskrift = tidsskrift;
	}
	
	public void setReferenceliste(Artikel[] referenceliste) {
		this.referenceliste = referenceliste;
	}
	public String getReferenceliste() {
		String output = "";
		output += referenceliste[0].toString();
		for(int i = 1; i < referenceliste.length; i++) {
			output += "; " + referenceliste[i].toString();
		}
		return output;
	}
	public String toString() {
		String output = "";
		output += forfattere[0];
		for(int i = 1; i < forfattere.length; i++) {
			if (i == forfattere.length - 1) {
				output += " & ";
			} else {
				output += ", ";
			}
			output += forfattere[i];
		}
		output += ": \"" + titel + "\". ";
		output += tidsskrift.getTitel() + ".";
		return output;
	}
}
