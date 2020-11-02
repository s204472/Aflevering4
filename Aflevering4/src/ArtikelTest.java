
public class ArtikelTest {

	public static void main(String[] args) {
		Forlag forlaget = new Forlag("Univeristy Press", "Denmark");
		Tidsskrift skrift1 = new Tidsskrift("Journal of Logic");
		skrift1.setForlag(forlaget);
		Tidsskrift skrift2 = new Tidsskrift("Brain");
		skrift2.setForlag(forlaget);
		System.out.println(forlaget.toString());
		
		Artikel artikel1 = new Artikel(new String[] {"A. Abe", "A. Turing"}, "A", skrift1);
		System.out.println(artikel1.toString());
		
		Artikel artikel2 = new Artikel(new String[] {"B. Bim"}, "B", skrift1);
		System.out.println(artikel2.toString());
		
		artikel1.setReferenceliste(new Artikel[] {artikel2, artikel2, artikel1});
		System.out.println(artikel1.getReferenceliste());
	}

}
