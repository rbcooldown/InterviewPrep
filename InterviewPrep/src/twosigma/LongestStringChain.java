package twosigma;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 给一个字符串数组, 以任意一个单词开始，删除一个字母 ，如果形成的新字符串还在数组的单词堆里面，则是合法的， 
 * chain长度增加1.然后继续往下删，每删一个则长度增加1. 
 * 举些例子吧：(a, abcd, bcd, abd, cd, c)：
 * abcd 删除一个字母可以变成 bcd ， abd， acd，abc。
 * 但是只有bcd， acd 可以往下走，所以下面只要考虑这两个。 
 * bcd 可以变成cd 再变成c。 但是abd删除一个单词不能变成数组的一个单词。所以停止。
 */
public class LongestStringChain {
	
	
	/*
	 * dfs solution. record the max length of a string could reach for future use
	 * This could help reduce depth of recursion. 
	 */
	public int longestChain(String[] word) {
		Set<String> all = new HashSet<String>();
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		for(String s: word)
			all.add(s);
		
		int maxLen = 0; // final result of max length
		
		for(String w : all) {
			if(w.length() > maxLen){ //bypass words that length less than found longest path
				countMap.put(w, dfsHelper(w, all, countMap)+1);
				maxLen = Math.max(maxLen, countMap.get(w));
			}
		}
		return maxLen;
	}
	
	public int dfsHelper(String s, Set<String> words, Map<String, Integer> countMap){
		int res = 0;
		for(int i=0; i<s.length(); i++ ){
			String to = s.substring(0, i) + s.substring(i+1);
			if(words.contains(to)){
				if(countMap.containsKey(to))
					res = Math.max(res, countMap.get(to));
				else
					res = Math.max(res, dfsHelper(to, words, countMap)+1);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] words = new String[]{"a", "abcd", "bcd", "abd", "cd", "c"};
		LongestStringChain lsc = new LongestStringChain();
		System.out.println(lsc.longestChain(words));
	}
}
