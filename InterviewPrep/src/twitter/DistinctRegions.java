package twitter;

/*
 * how many distinct regions can be delineated on a white sheet of paper by drawing 
 * N straight lines
 */
public class DistinctRegions {
	
	public int numOfRegion(int n) {
		if(n == 0) return 1;
		return n*(n+1)/2 + 1;
	}
	
	public static void main(String[] args) {
		DistinctRegions nrnl = new DistinctRegions();
		
		System.out.println(nrnl.numOfRegion(5));
	}

}
