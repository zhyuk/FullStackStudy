package generic_003_method2;

public class Pair<K, V> { // Integer, String
	private K key;   // Integer  1
	private V value;  // String "사과"
				// 1, "사과"
	public Pair(K key, V value) {
		this.key = key;  // 1
		this.value = value;  // "사과"
	}
	
	public void setKey(K key) { this.key = key; }
	public void setValue(V value) { this.value = value; }
	public K getKey()    { return key; }
	public V getValue()  { return value; }
	
}

 