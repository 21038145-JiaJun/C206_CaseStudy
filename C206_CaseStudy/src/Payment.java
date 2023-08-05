
public class Payment {
	
	private Auction auction;
	private Item item;
	private boolean paid;
	
	
	public Payment(Auction auction, Item item, boolean paid) {
		this.auction = auction;
		this.item = item;
		this.paid = paid;
	}

	public String isPaid() {
		if (paid == true) {
			return "Yes";
		} else {
			return "No";
		}
	}

	public Auction getAuction() {
		return auction;
	}


	public Item getItem() {
		return item;
	}
	
	public void makePayment() {
		if (paid == false) {
			System.out.println("Payment made successfully");
		} else {
			System.out.println("Payment has already been made");
		}
	}
	
}
