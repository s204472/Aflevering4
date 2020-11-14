
public class ArtikelTest {

	public static void main(String[] args) {
		Forlag forlag1 = new Forlag("University Press", "Denmark");
		Forlag forlag2 = new Forlag("1234 Bladet", "USA");
		Forlag forlag3 = new Forlag("(@)#", "132.156");
		
		
		Tidsskrift skrift1 = new Tidsskrift("");
		Tidsskrift skrift2 = new Tidsskrift("Brain");
		Tidsskrift skrift3 = new Tidsskrift("1234 all");
	
		skrift2.setIssn("21324654");
		skrift1.setForlag(forlag1);
		skrift2.setForlag(forlag2);
		skrift3.setForlag(forlag3);
		System.out.println(skrift1);
		System.out.println(skrift2);
		System.out.println(skrift3);
		System.out.println(forlag1);
		
//		Artikel artikel1 = new Artikel(new String[] {"A. Abe", "A. Turing"}, "A", skrift1);
//		System.out.println(artikel1);
//		
//		Artikel artikel2 = new Artikel(new String[] {"B. Bim"}, "B", skrift1);
//		System.out.println(artikel2);
//		
//		artikel1.setReferenceliste(new Artikel[] {artikel2, artikel2, artikel1});
//		System.out.println(artikel1.getReferenceliste());
	}

}
