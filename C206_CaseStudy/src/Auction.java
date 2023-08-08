
public class Auction {
	
	private int auctionID;
	private String description;
	private double currentBid;
	
	public Auction(int auctionID, String description, double currentBid) {
		super();
		this.auctionID = auctionID;
		this.description = description;
		this.currentBid = currentBid;
	}

	public double getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(double currentBid) {
		this.currentBid = currentBid;
	}

	public int getAuctionID() {
		return auctionID;
	}

	public String getDescription() {
		return description;
	}

	public String getStartingBid() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
