package generic_002_yes;
// &200 //&300
public class Product<T, M> { //Tv, String // Car, String
	private T kind; //Tv  &200   // Car
	private M model; // String  "Tv 자료형"  // String
								
	public T getKind() { return this.kind; } //Tv (1) // Car
	public M getModel() { return this.model; } // String  // String
						// &200
	public void setKind(T kind) { this.kind = kind; } //Tv //Car
	public void setModel(M model) { this.model = model; } //String  //String
						// "Tv 자료형"
}
