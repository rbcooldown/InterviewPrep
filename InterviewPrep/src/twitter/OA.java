package twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class OA{
	//****************deleteSubstring******************
	public int deleteSubstring(String s, String t){
		if(t.length() == 0){
			return 0;
		}
		int count = 0, preIndex = 0;
		while(s.length() >= t.length()){
			int index = s.indexOf(t, preIndex - t.length());
			if(index == -1){
				break;
			}else{
			s = s.substring(0, index) + s.substring(index + t.length());
				count ++;
				preIndex = index;
			}
		}
		return count;
	}

	//****************factorial******************
	public static void main1(String[] args){
			Scanner scanner = new Scanner(System.in);
			List<Long> cache = new ArrayList<Long>();
			cache.add((long)1);
			while(scanner.hasNext()){
				int num = scanner.nextInt();
				if(num < 0){
					break;
				}
				if(num > cache.size()){
					int last = cache.size();
					long value = cache.get(last -1);
					while(++last <= num){
						value*=last;
						cache.add(value);
					}
					System.out.println(value);
				}else{
					System.out.println(cache.get(num-1));
				}
			}
		}


	//****************two list find common num ******************
		public static int findCommonNum(int a1, int d, int b1, int q, int max){
			//q == +- 1 
			if (q == 1) {
				if (d != 0 && (b1 - a1) % d == 0) {
					return 1;
				}else if(d == 0 && a1 == b1){
					return 1;
				}else {
					return 0;
				}
			}
			if (q == -1) {
				int count = 0;
				if (d != 0 && (b1 - a1) % d == 0 && b1 >= a1) {
					count++;
				}
				if (d == 0 && b1 == a1){
					count++;
				}
				if (d != 0 && (-b1 - a1) % d == 0 && -b1 >= a1) {
					count++;
				}
				if (d == 0 && b1 == -a1){
					count++;
				}
				return count;
			}
			// d == 0 && q != +-1
			if(d == 0){
				while(b1 <= max){
					if(b1 == a1){
						return 1;
					}
					b1 *= q;
				}
				return 0;
			}
			
			//General Case
			int count = 0;
			while(b1 < max){
				if(b1 >= a1 && (b1 - a1) % d == 0){
					count ++;
				}
				b1 *= q;
			}
			return count;
		}


	//****************cutting bamboo******************
		public static List<Integer> cuttingBamboo(int[] nums){
			List<Integer> res = new ArrayList<Integer>();
			Arrays.sort(nums);
			int cutLen = 0;
			for(int i=0; i<nums.length; i++){
				if(cutLen < nums[i]){
					res.add(nums.length - i);
					cutLen = nums[i];
				}
			}
			return res;
		}

	//****************firstNonRepeatChar******************
		public static char firstNonRepeatChar(String s){
			int[] mark = new int[256];
			for(int i=0; i<s.length(); i++){
				char ch = s.charAt(i);
				mark[ch] = (mark[ch] != 0)? -1: i+1;
			}
			int min = Integer.MAX_VALUE;
			for(int i=0; i<mark.length; i++){
				if(mark[i] > 0 && mark[i] < min){
					min = mark[i];
				}
			}
			return s.charAt(min-1);
		}

	//****************fibonacci******************
		private static int[] fibonacci(int n){
			int[] arr = new int[n];
			if(n == 0 || n == 1){
				return arr;
			}
			arr[1] = 1;
			for(int i= 2; i<n; i++){
				arr[i] = arr[i-1] + arr[i-2];
			}
			return arr;
		}

	//****************Utopian Tree******************
	private static void getHeight(int n){
	        long height = 1;
	        boolean spring = true;
	        for(int i=0; i<n; i++){
	            if(spring){
	                height = height << 1;
	                spring = false;
	            }else{
	                height += 1;
	                spring = true;
	            }
	        }
	        System.out.println(height);
	    }

	//****************countPrime******************
	public int countPrimes(int n) {
	        boolean[] notPrime = new boolean[n+1];
	        int count = 0;
	        for(int i=2; i<n;i++){
	            if(!notPrime[i]){
	                count++;
	                for(int j=2; i*j < n; j++){
	                    notPrime[i*j] = true;
	                }
	            }
	        }
	        return count;
	    }


	//****************Valid Parentheses******************
	    public boolean isValid(String s) {
	        Map<Character, Character> hm = new HashMap<Character, Character>();
	        hm.put(')', '(');
	        hm.put(']', '[');
	        hm.put('}', '{');
	        
	        Stack<Character> stack = new Stack<Character>();
	        for(int i=0; i<s.length(); i++){
	            char ch = s.charAt(i);
	            if(hm.containsKey(ch)){
	                if(stack.size() == 0 || stack.pop() != hm.get(ch)){
	                    return false;
	                }
	            }else{
	                stack.add(ch);
	            }
	        }
	        return stack.size() == 0;
	    }

	//****************Urler Function******************
	private static int ruler(int n){
			int res = n;
			for(int i = 2; i<=n; i++){
				if(n % i == 0){
					res *= (1 - (double)1/i);
					while(n % i == 0){
						n = n / i;
					}
				}
			}
			return res;
		}

	//****************isTheNumberRepeat******************
	private static void isTheNumberRepeat(int[] nums){
			Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
			String left = "";
			for(int i=0; i<nums.length; i++){
				if(hm.containsKey(nums[i])){
					left += "1";
					hm.put(nums[i], i);
				}else{
					left += "0";
					hm.put(nums[i], i);
				}
			}
			System.out.println(left);
			
			String right = "";
			for(int i = nums.length - 1; i>= 0; i--){
				if(hm.containsKey(nums[i])){
					if(i == hm.get(nums[i])){
						right = "0" + right;
					}else{
						right = "1" + right;
					}
				}else{
					right = "0" + right;
				}
			}
			System.out.println(right);
		}

	//****************flipOneZero******************
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner scanner = new Scanner(System.in);
			int len = scanner.nextInt();
			int[] nums = new int[len];
			for(int i=0; i<len; i++){
				nums[i] = scanner.nextInt();
			}
			
			System.out.println(flipOneZero(nums));
		}
		
		private static int flipOneZero(int[] nums){
			int maxFlip = 0, countOne = 0, countFlip = 0;
			for(int i=0; i<nums.length; i++){
				if(nums[i] == 1){
					countOne++;
					countFlip--;
					if(countFlip < 0){
						countFlip = 0;
					}
				}else{
					countFlip++;
					maxFlip = Math.max(maxFlip, countFlip);
				}
			}
			return countOne + maxFlip;
		}

	//****************flipNumber******************
		private static int flipNumber(int n){
			int shift = 0, res = 0;
			while(n > 0){
				res += (1 ^ (n & 1)) << shift++;
				n >>>= 1;
			}
			return res;
		}

		private static boolean checkFlagValid(int m, int n, String[] matrix){
			if(matrix.length == 0){
				return false;
			}
			if(!checkLine(matrix[0], n))	return false;
			char preColor = matrix[0].charAt(0);
			return false;
		}
		
		private static boolean checkLine(String s, int n){
			if(s.length() == n){
				return false;
			}
			char ch = s.charAt(0);
			for(int i=1;i<s.length();i++){
				if(ch != s.charAt(i)){
					return false;
				}
			}
			return true;
		}
}

