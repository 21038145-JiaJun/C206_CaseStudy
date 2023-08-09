
public class Bid{
	private int auctionID;
	private String description;
	private double bidding;
	
	
	
	public Bid(int auctionID, String description, double bidding) {
		super();
		this.auctionID = auctionID;
		this.description = description;
		this.bidding = bidding;
	}

	public int getAuctionID() {
		return auctionID;
	}

	public String getDescription() {
		return description;
	}





	public void setBidding(double bidding) {
		this.bidding = bidding;
	}

	public double getBidding() {
		return bidding;
	}
	

}
