package model;

public class Trainer {
	// instance variables
	private int id;
	private String brandName;
	private String trainerName;
	private String colour;
	private float size;
	private String condition;
	private String description;
	private int price;

	// constructors for the trainer variables
	public Trainer(int id, String brandName, String trainerName, String colour, float size, String condition,
			String description, int price) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.trainerName = trainerName;
		this.colour = colour;
		this.size = size;
		this.condition = condition;
		this.description = description;
		this.price = price;
	}

	// getters and setters generated
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public float getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
