
public class Forlag {
	private String navn;
	private String sted;
	public Forlag (String navn, String sted) {
		this.sted = sted;
		this.navn = navn;
	}
	public String toString() {
		return navn + ", " + sted;
	}
}
