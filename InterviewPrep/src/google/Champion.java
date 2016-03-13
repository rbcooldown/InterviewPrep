package google;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Edward
 * This is a dfs solution for a google interview question 
 * to calculate probability of a team to win champion
 *  
 */
public class Champion {
	// a tree node of a team
	static class Node {
		int no;
		boolean hit;
		Node left;
		Node right;
		public Node(){
			hit = false;
			no = -1;
			left = null;
			right = null;
		}
		public Node(int no) {this.no = no;}
	}
	
	// probability of a team.
	static class Prob {
		int no;
		double prob;
		public Prob(int no, double d) { this.no = no; this.prob = d;}
		
	}
	
	// probability lookup table
	public static Double[][] table;
	
	/**
	 * 
	 * @param root
	 * @param target the target team
	 * @return
	 * 		return the probability to win champion for the target team.
	 */
	public static List<Prob> solve(Node root, int target) {
		if (root == null) return new ArrayList<Prob>();
		List<Prob> left = solve(root.left, target);
		List<Prob> right = solve(root.right, target);
		
		// non-leaf node
		if(!left.isEmpty() && !right.isEmpty()) {
			if (root.left.hit || root.right.hit) {	// found target in either subtree
				root.hit = true;
				List<Prob> others = root.left.hit? right:left;
				List<Prob> t = root.left.hit? left:right;
				
				double sum = 0;
				for (Prob prob :others) {
					double weight = table[target][prob.no];
					sum += weight*prob.prob;
				}
				root.left.hit = false;
				root.right.hit = false;
				t.get(0).prob = t.get(0).prob*sum;
				return t;
			}
			else { // target not found  in both subtree
				List<Prob> teams = new ArrayList<Prob>();
				// calculate probabilities of teams to next round(upper level) in left subtree
				for(Prob prob: left){
					double sum = 0;
					for(Prob other : right){
						double weight = table[prob.no][other.no];
						sum += weight*other.prob;
					}
					teams.add(new Prob(prob.no, prob.prob*sum));
				}
				// calculate probabilities of teams to next round in right subtree
				for(Prob prob:right) {
					double sum = 0;
					for(Prob other:left) {
						double weight = table[prob.no][other.no];
						sum += weight*other.prob;
					}
					teams.add(new Prob(prob.no, prob.prob*sum));
				}
				// combine and return probabilities of all teams to upper level
				return teams;
			}
		}
		else if (root.no == target) // leaf node
			root.hit = true;
		Prob prob = new Prob(root.no, 1);
		ArrayList<Prob> ans = new ArrayList<Prob>();
		ans.add(prob);
		return ans;
	}
	
	public static void main(String[] args) {
		table = new Double[][]{{1.0,0.3,0.4,0.8},{0.7,1.0,0.5,0.6},{0.6,0.5,1.0,0.1},{0.2,0.4,0.9,1.0}};
		Node root = new Node(-1);
		root.left = new Node(-1);
		root.right = new Node(-1);
		root.left.left = new Node(0);
		root.left.right = new Node(1);
		root.right.left = new Node(2);
		root.right.right = new Node(3);
		Double total = 0.0;
		for(int i= 0; i< 4; i++) {
			Double res = solve(root, i).get(0).prob;
			System.out.println("Target " +i + ": " + res);
			total += res;
		}
		
		System.out.println(total);
		
	}

}
