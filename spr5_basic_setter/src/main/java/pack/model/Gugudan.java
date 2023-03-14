package pack.model;

public class Gugudan implements CalcInter{
	public int[] numCalc(int su) {
		int[]  cal = new int[9];
		for (int i = 0; i < 9; i++) {
			cal[i] = su * (i + 1);
		}
		return cal;
	}
}
