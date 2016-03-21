package twosigma;

import java.util.HashSet;
import java.util.Set;

/*
 * calculate numbers of distinct substring palindromes.
 */
public class SubstringPalindrome {

	/*
	 * dp solution. need O(n^2) space to store palindrome state.
	 * 
	 */
	public int countSubstringPalin(String s) {
		int len = s.length();
		int count = 0;
		
		Set<String> repeated = new HashSet<String>();
		boolean[][] isPalin = new boolean[len][len];
		
		for(int i=0; i<len; i++){
			for(int j=0; j<=i; j++) {
				if(s.charAt(i) == s.charAt(j) && (i-j < 2 || isPalin[j+1][i-1])){
					isPalin[j][i] = true;
					if(repeated.add(s.substring(j, i+1))){
						count++;
					}
				}
			}
		}
		return count;		
	}
	
	/*
	 * better solution. O(n^2) time complexity
	 * O(1) space
	 */
	public int countSubstringPalin2(String s) {
		int len = s.length();
		int count = 0;
		Set<String> repeated = new HashSet<String>();
		for(int i=0; i<len; i++) {
			for(int k=0; i-k>=0 && i+k<len && s.charAt(i-k) == s.charAt(i+k); k++)
				if(repeated.add(s.substring(i-k, i+k+1)))
					count++;
			for(int k=0; i-k-1>=0 && i+k<len && s.charAt(i-k-1)== s.charAt(i+k); k++)
				if(repeated.add(s.substring(i-k-1, i+k+1)))
					count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		String s = "ababbabaaabaabbaabbbaabbaabababbabbaabababb";
		SubstringPalindrome sp = new SubstringPalindrome();
		long time = System.currentTimeMillis();
		int i = 0;
		while( i++ < 10000)
			sp.countSubstringPalin(s);
//		System.out.println(sp.countSubstringPalin(s));
		System.out.println("running time:" + (System.currentTimeMillis() - time + "ms"));
		
		time = System.currentTimeMillis();
		while(i-->=0)
			sp.countSubstringPalin2(s);
//		System.out.println(sp.countSubstringPalin2(s));
		System.out.println("running time:" + (System.currentTimeMillis() - time + "ms"));
	}
}
