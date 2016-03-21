package twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        List<Integer>  cache = new ArrayList<Integer>();
        cache.add(1);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            if(n < 0) break;
            if(n > cache.size()){
                int t = cache.size();
                int val = cache.get(t-1);
                while(++t <= n) {
                    val *= t;
                    cache.add(val);
                }
                System.out.println(val);
            }
            else
                System.out.println(cache.get(n-1));
        }
    }
}
