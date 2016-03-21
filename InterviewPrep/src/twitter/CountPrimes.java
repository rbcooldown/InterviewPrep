package twitter;

/*
 * 输入一个正整数N，求1<=X<=N中，满足(X-1)!%X==X-1的X的个数。N有个范围，最大大概是到10^6?
 */
public class CountPrimes {

	public int countPrime(int n) {
		boolean[] isPrime = new boolean[n+1];
		for(int i=2; i<=n; i++)
			isPrime[i] = true;
		int count = 0;
		for(int i = 2; i <= n; i++) {
			if(isPrime[i]) {
				count++;
				for(int j=2; i*j <=n;j++)
					isPrime[i*j] = false;
			}
		}
		
		return count;
	}
	
	
}
