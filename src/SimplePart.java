
public class SimplePart implements Part {
    private String name, data;
    private double price;

    public SimplePart(String name) {
    	this.name = name;
    	data = null;
    	price = 0;
    }
    
    public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public void addPart(Part part) {
		//Do liœcia nie mo¿na dodawaæ obiektów
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		return this.price;
	}
	
	@Override
	public String getData() {
		String s = "Nazwa: " +name + "\n" +
				"Cena: " + price + " z³\n" + 
				"Opis: " + data;
		return s;
	}
	
	public void setData(String s){
		data = s;
	}
	
	public String toString(){
		return this.name;
	}
}
