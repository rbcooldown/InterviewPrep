package twitter;

public class FlipOneZero {

	public int flip(int[] nums) {
		int maxFlip = 0;
		int countOne =0, countZero = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == 1){
				countOne++;
				if(countZero > 0)
					countZero--;
			}
			else {
				countZero++;
				maxFlip = Math.max(maxFlip, countZero);
			}
		}
		return maxFlip + countOne;
	}
}
