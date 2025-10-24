package textproc;

import java.util.*;

public class MultiWordCounter implements TextProcessor {
	private Map<String, Integer> wordCount = new TreeMap<>();
	
	public MultiWordCounter(String[] words) {
		for (String word : words) {
			wordCount.put(word, 0);
		}
	}
	
	@Override
	public void process(String word) {
		if (wordCount.containsKey(word)) {
			wordCount.put(word, wordCount.get(word) + 1);
		}
	}
	
	@Override
	public void report() {
		for (String key : wordCount.keySet()) {
			System.out.printf("%-15s  %s %n", key + ": ", wordCount.get(key));
		}
	}
}
