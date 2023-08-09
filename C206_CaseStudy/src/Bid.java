
public class Bid{
	private int bidID;
	private String description;
	private double bidding;
	
	
	
	public Bid(int bidID, String description, double bidding) {
		super();
		this.bidID = bidID;
		this.description = description;
		this.bidding = bidding;
	}

	public int getBidID() {
		return bidID;
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
