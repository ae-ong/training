package pack.model;

public class SangpumImpl implements SangpumInter{
	public int calcMoney(int ea, int price) {
		int totalPrice = ea * price;
		return totalPrice;
	}
}
