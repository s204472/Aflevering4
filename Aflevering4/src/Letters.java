
public class Letters {
	/*
	 * Program using main args as arguments
	 */
	public static void main(String[] args) {
		int number = 0;
		for(int i = 0; i < args.length; i++) {
			number += args[i].length();
		}
		System.out.println(number);

	}

}