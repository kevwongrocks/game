public class RandomSequence {
	
	public static int[] attackSequence() {
		
		int[] attack = new int[9];
		
		for(int i = 0; i <= 8; i++) {
			attack[i] = RandomAttack.randInt(0, 2);
		}
		
		return attack;
		
	}
	
}