package twosigma;

/*
 * There are N students in a class. Some of them are friends, 
 * while some are not. Their friendship is transitive in nature, 
 * i.e., if A is friend of B and B is friend of C, 
 * then A is also friend of C. A friend circle is a group of students 
 * who are directly or indirectly friends. You are given a N×N−matrix M 
 * which consists of characters Y or N. If M[i][j]=Y, 
 * then ith and jth students are friends with each other, otherwise not. 
 * You have to print the total number of friend circles in the class.
 * 
 * 
 */
public class FriendCycles {
	public int[] relations;
	volatile int[] N;
	public int friendCycles(String[] friends){
		int n = friends.length;
		relations = new int[n];
		// init each person's friend cycle.
		for(int i=0; i<n; i++)
			relations[i] = i;
		
		for(int i=0; i<n; i++) {
			char[] chars = friends[i].toCharArray();
			for(int j=0; j<chars.length; j++) {
				if(i !=j && chars[j] == 'Y'){
					int rootX = root(i);
					int rootY = root(j);
					if(rootX != rootY){
						// compress tree
						relations[i] = rootY;
						relations[rootX] = rootY;
					}
				}
			}
		}
		int count = 0;
		for(int i=0; i<n; i++)
			if(i == relations[i])
				count++;
		return count;
	}
	
	private int root(int x) {
		while(x != relations[x]){
			// path compress the tree
			relations[x] = relations[relations[x]];
			x = relations[x];
		}
		return x;
	}
	
	
	public static void main(String[] args){
		String[] friends = new String[]{"YYNN", "YYYN", "NYYN", "NNNY"};
		FriendCycles fc = new FriendCycles();
		System.out.println(fc.friendCycles(friends));
	}
}
