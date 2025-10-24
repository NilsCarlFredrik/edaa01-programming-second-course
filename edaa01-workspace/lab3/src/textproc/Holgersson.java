package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", 
			"gotland", "gästrikland", "halland", "hälsingland", "härjedalen", "jämtland", 
			"lappland", "medelpad", "närke", "skåne", "småland", "södermanland", "uppland",
			"värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		
		long t0 = System.nanoTime();
		
		//for (int i=0 ; i<50 ; i++) {
		
		List<TextProcessor> counters = new ArrayList<>();
		
		counters.add(new SingleWordCounter("nils"));
		counters.add(new SingleWordCounter("norge"));
		
		counters.add(new MultiWordCounter(REGIONS));
		
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		Set<String> stopwords = new HashSet<>();
		while (scan.hasNext()) {
			String stopword = scan.next().toLowerCase();
			stopwords.add(stopword);
		}
		
		counters.add(new GeneralWordCounter(stopwords));

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();

			for(TextProcessor counter : counters) {
				counter.process(word);
			}
		}

		s.close();

		for(TextProcessor counter : counters) {
			System.out.println(" ");
			counter.report();
		}
		//}
		long t1 = System.nanoTime();
		System.out.println("\nTid: "+ (t1-t0)/1000000.0 + " ms");
	}
}

// 50 körningar:		Hash: 11.9 s  Tree: 12.5 s -> Hash ~ 5% snabbare