package map;

import java.util.Random;

public class SimpleHashMap<K, V> implements Map<K, V> {
	private Entry<K, V>[] table;
	private int size = 0;
	
	
	/** Constructs an empty hashmap with the default initial capacity (16)
	and the default load factor (0.75). */
	public SimpleHashMap() {
		table = (Entry<K, V>[]) new Entry[16];
	}
	
	/** Constructs an empty hashmap with the specified initial capacity
	and the default load factor (0.75). */
	public SimpleHashMap(int capacity) {
		table = (Entry<K, V>[]) new Entry[capacity];
	}
	
	
	public static void main(String[] args) {
		SimpleHashMap<Integer, Integer> testMap;
		testMap = new SimpleHashMap<Integer, Integer>();
		Random rand = new Random();
		
		for (int i = 0 ; i < 200 ; i++) {
			int randomNumber = rand.nextInt(1000)-500;
			testMap.put(randomNumber, randomNumber);
		}
		
		System.out.println(testMap.show());
	}
	
	
	@Override
	public V get(Object object) { 				//varför inte key?
		// TODO Auto-generated method stub
		Entry<K, V> temp = find(index((K) object), (K) object);

		if (temp != null) {
			return temp.getValue();
		} else {
			return null;	
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}
	
	@Override
	public V put(K key, V value) {
		Entry<K, V> temp = find(index(key), key);
		
		if (temp != null) {
			V oldValue = temp.getValue();
			temp.setValue(value);
			if (size() >= 0.75 * table.length) {
				rehash();
			}
			return oldValue;
		} else {
			if (table[index(key)] == null) {
				table[index(key)] = new Entry<K, V>((K) key, (V) value);
			} else {
				temp = table[index(key)];
				while (temp.getNext() != null) {
					temp = temp.getNext();
				}
				temp.setNext(new Entry<K, V>((K) key, (V) value));
			}
			size++;
			if (size() >= 0.75 * table.length) {
				rehash();
			}
			return null;
		}

	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			Entry<K, V> temp = find(index((K) key), (K) key);
			Entry<K, V> oldTemp = table[index((K) key)];

			if (temp != null) {
				V oldValue = temp.getValue();
				if (temp.getKey().equals(oldTemp.getKey())) {
					if (temp.next != null) {
						table[index((K) key)] = temp.getNext();
						size--;
						return oldValue;
					}
					else {
						table[index((K) key)] = null;
						size--;
						return oldValue;
					}
				}
				while (oldTemp.getNext() != null) {
					if (oldTemp.getNext().getKey().equals(temp.getKey())) {
						oldTemp.setNext(temp.getNext());
						size--;
						return oldValue;
					} else if (oldTemp.getNext().getNext() == null) {
						oldTemp.getNext().setNext(null);
						size--;
						return oldValue;
					} else {
						oldTemp = oldTemp.getNext();
					}
				}
			}
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	private int index(K key) {
		return Math.abs(key.hashCode() % table.length);
	}
	
	private Entry<K, V> find(int index, K key) {
		Entry<K, V> temp = table[index];

		while (temp != null) {
			if (temp.getKey().equals(key)) {
				return temp;
			} else {
				temp = temp.getNext();
			}
		}
		return null;

	}
		
	private String show() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				sb.append(i + "    " + table[i].toString());
//				sb.append(i + " ".repeat(5-((int) Math.log10(i))) + table[i].toString());
				Entry<K, V> temp = table[i];
				while (temp.next != null) {
//					sb.append(" " + temp.getNext().toString());					
					sb.append(" ".repeat(10-temp.toString().length()) + temp.getNext().toString());
					temp = temp.getNext();
				}
				sb.append("\n");
			} else {
				sb.append(i + "    null\n");
//				sb.append(i + " ".repeat(5-((int) Math.log10(i))) + "null\n");
			}
		}
		return sb.toString();
	}
	
	private void rehash() {
		Entry<K, V>[] oldTable = table;
		table = (Entry<K, V>[]) new Entry[table.length * 2];
		size = 0;
		for (int i = 0; i < oldTable.length; i++) {
			Entry<K, V> temp = oldTable[i];
			while (temp != null) {
				put(temp.getKey(), temp.getValue());
				temp = temp.getNext();
			}
		}
	}
	
	private static class Entry<K,V> implements Map.Entry<K,V> {
		K key;
		V value;
		Entry<K, V> next;
		
		private Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public V setValue(V newValue) {
			// TODO Auto-generated method stub
			return value = newValue;
		}
		
		@Override 
		public String toString() {
			return key.toString() + "=" + value.toString();
		}
		
		private Entry<K, V> setNext(Entry<K, V> next) {
			this.next = next;
			return this.next;
		}
		
		public Entry<K, V> getNext() {
			return this.next;
		}
	}

}
