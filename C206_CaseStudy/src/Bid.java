
public class Bid extends Item{
	private double bidding;
	
	public Bid(String assetTag, String description, double bidding) {
		super(assetTag, description);
		this.bidding = bidding;
	}

	public void setBidding(double bidding) {
		this.bidding = bidding;
	}

	public double getBidding() {
		return bidding;
	}
	

}
