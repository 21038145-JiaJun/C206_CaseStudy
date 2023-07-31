public class Object extends Item{
	private int price;

	public Object(String assetTag, String description, int price) {
		super(assetTag, description);
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
	
	public String toString(){
		String output = super.toString();
		output = String.format("%-63s %-20d", output, price);
		
		return output;
	}
}