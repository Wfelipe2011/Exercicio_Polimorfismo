package entities;

public class ImportedProduct extends Product {
	
	private Double customsfreight;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsfreight) {
		super(name, price);
		this.customsfreight = customsfreight;
	}

	public Double getCustomsfreight() {
		return customsfreight;
	}

	public void setCustomsfreight(Double customsfreight) {
		this.customsfreight = customsfreight;
	}
	
	public final Double totalPrice() {
		return  customsfreight + price; 
	}
	
	@Override
	public final String priceTag() {
		return super.priceTag() + " (Custo do Frete: $ " + String.format("%.2f", customsfreight) +")" ;
	}
}
