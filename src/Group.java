import java.util.ArrayList;
import java.util.List;

public class Group implements Part {
    private List<Part> parts = new ArrayList<Part>();
    private String name, data;

    public Group(String name) {
    	this.name = name;
    }
    
    public void addPart(Part part) {
    	parts.add(part);
    }

	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		double sum = 0;
		for(Part p : parts){
			sum = sum + p.getPrice();
		}
		return sum;
	}

	@Override
	public String getData() {
		String s = "Nazwa: " +name + "\n" +
					"Cena: " + this.getPrice() + " z³\n" + 
					"Opis: " + data;
		for(Part p : parts){
			s += 
					"\n" + p.getData() + "\n"
					+ "---------------------------------------------------------------------------"
					+ "";
		}
		return s;
	}
	
	public void setData(String s){
		data = s +"\n\n"
				+"-----------------------------------------------------------------------\n";
	}

	@Override
	public void setPrice(double d) {
		//Dla grup cena obliczana jest automatycznie
	}
	
	public String toString(){
		return this.name;
	}
}