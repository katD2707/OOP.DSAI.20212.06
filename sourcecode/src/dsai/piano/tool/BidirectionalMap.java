package dsai.piano.tool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BidirectionalMap<K, V> extends HashMap<K, V> {
	Map<V, K> inversedMap = new HashMap<V, K>();
	
	public K getKey(V value) {
		return inversedMap.get(value);
	}
	
	@Override
	public V put(K key, V value) {
		this.inversedMap.put(value, key);
		return super.put(key, value);
	}
	
	
	@Override
	public V remove(Object key) {
		V val = super.remove(key);
		inversedMap.remove(val);
		return val;
	}

	public Set<V> valueSet() {
		return this.inversedMap.keySet();
	}

}
