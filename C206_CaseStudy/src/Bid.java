
public class Bid extends Auction{
	private double bidding;

	public Bid(int auctionID, String description, double currentBid) {
		super(auctionID, description, currentBid);
	}

	public void setBidding(double bidding) {
		this.bidding = bidding;
	}

	public double getBidding() {
		return bidding;
	}
	

}
