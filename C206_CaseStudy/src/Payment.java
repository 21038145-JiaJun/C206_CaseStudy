
public class Payment {
	
	private int paymentID;
	private Auction auction;
	private Item item;
	private boolean paid;
	
	
	public Payment(int paymentID, Auction auction, Item item, boolean paid) {
		this.paymentID = paymentID;
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

	public int getPaymentID() {
		return paymentID;
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
