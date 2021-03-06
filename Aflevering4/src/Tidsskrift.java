/*
 * Object representing a tidsskrift
 */
public class Tidsskrift {
	private String titel;
	private Forlag forlag;
	private String issn;
	
	public Tidsskrift(String titel) {
		this.titel = titel;
	}
	public void setIssn(String issn) {
		this.issn = issn;
	}
	public void setForlag(Forlag forlag) {
		this.forlag = forlag;
	}
	public String getTitel() {
		return titel;
	}
	public String toString() {
		String s = "";
		s += titel != ""  ?  titel : "Titel ikke angivet";
		s += issn != null ?  ", " + issn : ", Issn ikke angivet";
		s += forlag != null ? ", " + forlag : ", Forlag ikke angivet.";
		return s;
	}
}
