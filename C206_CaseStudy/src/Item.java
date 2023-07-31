
public class Item {
	private String assetTag;
	private String description;

	public Item(String assetTag, String description) {
		this.assetTag = assetTag;
		this.description = description;
	}
	
	
	public String getAssetTag() {
		return assetTag;
	}

	public String getDescription() {
		return description;
	}

}
