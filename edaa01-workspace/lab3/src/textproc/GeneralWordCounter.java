package textproc;

import java.util.*;

public class GeneralWordCounter implements TextProcessor {
	private Map<String, Integer> wordCount = new TreeMap<>();
	private Set<String> exceptions = new HashSet<>();
	
	
	public GeneralWordCounter(Set<String> exceptions) {
		this.exceptions = exceptions;
	}

	@Override
	public void process(String word) {
		if (exceptions.contains(word)) {
			return;
		} else if (wordCount.containsKey(word)) {
			wordCount.put(word, wordCount.get(word) + 1);
		} else {
			wordCount.put(word, 1);
		}
	}
	
	@Override
	public void report() {
		Set<Map.Entry<String, Integer>> wordSet = wordCount.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		
		wordList.sort(new WordCountComparator());
		
		int nbrOfWords = 50;
		
		System.out.println("\nDe " + nbrOfWords + " vanligaste orden: \n");
		System.out.printf("%-15s %s %n%s %n", 
				"Ord:", "Antal:", "-------------------------");
		
		for (int i = 0 ; i < nbrOfWords ; i++) {
			System.out.printf("%-15s %s%n",
					wordList.get(i).getKey() + ":", wordList.get(i).getValue());			
		}
		
		
		
//		System.out.println("\nOrd som förekommer över 200 ggr \n");
//		System.out.printf("%-15s  %s %n%s %n", 
//				"Ord:", "Antal:", "-------------------------");
//		for (String key : wordCount.keySet()) {
//			if (wordCount.get(key) >= 200) {
//				System.out.printf("%-15s  %s %n", 
//						key + ": ", wordCount.get(key));
//			}
//		} 
	
	}
	
	public List<Map.Entry<String, Integer>> getWordList() {
		Set<Map.Entry<String, Integer>> wordSet = wordCount.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
//		wordList.sort(new WordCountComparator());
		
		return wordList;
	}
}
