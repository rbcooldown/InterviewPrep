package twosigma;

public class EncircularDetect {
	
	private int x = 0, y = 0;	// start position
	int dir = 0;	// initial direction towards east
	public boolean circleExist(String path) {
		for(int i=0; i< 4; i++) {
			
			for(int j = 0; j< path.length(); j++) {
				switch(path.charAt(j)){
				case 'F':
					moveStep();
					break;
				case 'L':
					dir = (dir+4-1)%4;
					break;
				case 'R':
					dir = ++dir%4;
					break;
				}
			}
		}
		
		return x == 0 && y == 0 && dir == 0;
	}
	
	private void moveStep(){
		switch(dir){
		case 0:
			x++;
			break;
		case 1:
			y--;
			break;
		case 2:
			x--;
			break;
		case 3:
			y++;
			break;
		}
	}
	
	public static void main(String[] args) {
		EncircularDetect ed = new EncircularDetect();
		String op = "FRFRFRF";
		System.out.println(ed.circleExist(op));
	}
}
