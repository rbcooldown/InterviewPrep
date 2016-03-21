package twitter;

public class SuperPower {

	public int superPower(int x) {
		
		for(int i = (int) Math.sqrt(x); i>=2; i--) {
			if(x%i == 0) {
				int p = i;
				while(p < x) {
					p *= i;
					if(p == x)
						return 1;
				}
			}
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		int test = 255;
		SuperPower sp = new SuperPower();
//		long start = System.currentTimeMillis();
//		int n = 1000000;
//		while(n-- > 0) {
//			sp.superPower(test);
//		}
//		System.out.println(System.currentTimeMillis() - start + "ms");
		System.out.println(sp.superPower(test));
	}
}
