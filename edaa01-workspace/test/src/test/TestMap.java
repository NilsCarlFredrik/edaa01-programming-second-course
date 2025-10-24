package test;
import java.util.*;

public class TestMap {
	public static void main(String[] args) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			System.out.println(map.get("A") + " " + map.size());
			map.put("A", 43);
			System.out.println(map.get("A") + " " + map.size());
			map.put("A", 42);
			System.out.println(map.get("A") + " " + map.size());
	}
}
