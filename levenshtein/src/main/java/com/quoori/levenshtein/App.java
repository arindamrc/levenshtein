package com.quoori.levenshtein;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
	private static String characters = "abcdefghijklmnopqrstuvwxyz";
	private static Random r = new Random();
	
    public static void main( String[] args )
    {
    	// program must have at least one argument
    	if (args.length == 0) {
			showUsage();
			return;
		}
    	
    	// program cannot have more than 3 arguments
    	if (args.length > 4) {
			System.out.println("Unrecognized Arguments!");
			showUsage();
			return;
		}
    	
    	// for performance testing
    	if (args.length == 1) {
			if (!args[0].equals("-p")) {
				System.out.println("Unrecognized Arguments!");
				showUsage();
				return;
			}
			testPerformance();
			return;
		}
    	
    	// unbounded case
    	if (args.length == 3 && args[0].equals("-u")) {
			String s1 = args[1];
			String s2 = args[2];
			Levenshtein l = new Levenshtein();
			int distance = l.distance(s1, s2);
			System.out.println("Unbounded levenshtein distance: " + distance);
		} else if (args.length == 4 && args[0].equals("-b")) { // bounded case
			int k = 0;
			try {
	            k = Integer.parseInt(args[1]);
	        } catch (NumberFormatException e) {
	        	System.out.println("Bound could not be parsed!");
	        	showUsage();
	        	return;
	        }
			String s1 = args[2];
			String s2 = args[3];
			Levenshtein l = new Levenshtein();
			int distance = l.distanceBounded(s1, s2, k);
			System.out.println("Bounded levenshtein distance: " + distance);
		} else {
			System.out.println("Unrecognized Arguments!");
			showUsage();
			return;
		}
    	
    }
    
    /**
     * Show application usage.
     */
    private static void showUsage() {
    	System.out.println("**********Levenshtein distance calculator**********");
    	System.out.println("Usage:");
    	System.out.println("To launch performance tests: -p");
    	System.out.println("To calculate unbounded levenshtein distance: -u <string1> <string2>");
    	System.out.println("To calculate bounded levenshtein distance: -b <bound> <string1> <string2>");
    }
    
    /**
     * Run performance tests.
     */
    private static void testPerformance() {
		testPerformanceUnbounded_1();
		testPerformanceUnbounded_2();
		testPerformanceUnbounded_3();
		testPerformanceUnbounded_4();
		testPerformanceUnbounded_100_Equal();
		testPerformanceUnbounded_1000_Equal();
		testPerformanceUnbounded_10000_Equal();
		testPerformanceUnbounded_100000_Equal();
		testPerformanceUnboundedRecursive_10_Equal();
		testPerformanceUnbounded_100_Unequal();
	}

	private static void testPerformanceUnbounded_100000_Equal() {
		final int stringLength = 100000;
		StringBuilder b1 = new StringBuilder();
		StringBuilder b2 = new StringBuilder();
		
		for (int i = 0; i < stringLength; i++) {
			b1.append(characters.charAt(r.nextInt(characters.length())));
			b2.append(characters.charAt(r.nextInt(characters.length())));
		}
		
		String s1 = b1.toString();
		String s2 = b2.toString();
		
		Levenshtein l = new Levenshtein();
		long start = System.nanoTime();
		l.distance(s1, s2);
		long duration = System.nanoTime() - start;
		System.out.println("Length 100000 equal strings duration: " + duration + " ns " + "or " + duration / 1e9 + " s.");
		
	}

	private static void testPerformanceUnbounded_100_Unequal() {
		final int stringLength = 100;
		StringBuilder b1 = new StringBuilder();
		
		for (int i = 0; i < stringLength; i++) {
			b1.append(characters.charAt(r.nextInt(characters.length())));
		}
		
		String s1 = b1.toString();
		String s2 = "h";
		
		Levenshtein l = new Levenshtein();
		long start = System.nanoTime();
		l.distanceRecursive(s1, s2);
		long duration = System.nanoTime() - start;
		System.out.println("Length 100 string against length 1 duration: " + duration + " ns " + "or " + duration / 1e9 + " s.");
	}

	private static void testPerformanceUnboundedRecursive_10_Equal() {
		final int stringLength = 10;
		StringBuilder b1 = new StringBuilder();
		StringBuilder b2 = new StringBuilder();
		
		for (int i = 0; i < stringLength; i++) {
			b1.append(characters.charAt(r.nextInt(characters.length())));
			b2.append(characters.charAt(r.nextInt(characters.length())));
		}
		
		String s1 = b1.toString();
		String s2 = b2.toString();
		
		Levenshtein l = new Levenshtein();
		long start = System.nanoTime();
		l.distanceRecursive(s1, s2);
		long duration = System.nanoTime() - start;
		System.out.println("Length 10 equal strings duration (recursive): " + duration + " ns " + "or " + duration / 1e9 + " s.");
	}

	private static void testPerformanceUnbounded_10000_Equal() {
		final int stringLength = 10000;
		StringBuilder b1 = new StringBuilder();
		StringBuilder b2 = new StringBuilder();
		
		for (int i = 0; i < stringLength; i++) {
			b1.append(characters.charAt(r.nextInt(characters.length())));
			b2.append(characters.charAt(r.nextInt(characters.length())));
		}
		
		String s1 = b1.toString();
		String s2 = b2.toString();
		
		Levenshtein l = new Levenshtein();
		long start = System.nanoTime();
		l.distance(s1, s2);
		long duration = System.nanoTime() - start;
		System.out.println("Length 10000 equal strings duration: " + duration + " ns " + "or " + duration / 1e9 + " s.");
	}

	private static void testPerformanceUnbounded_1000_Equal() {
		final int stringLength = 1000;
		StringBuilder b1 = new StringBuilder();
		StringBuilder b2 = new StringBuilder();
		
		for (int i = 0; i < stringLength; i++) {
			b1.append(characters.charAt(r.nextInt(characters.length())));
			b2.append(characters.charAt(r.nextInt(characters.length())));
		}
		
		String s1 = b1.toString();
		String s2 = b2.toString();
		
		Levenshtein l = new Levenshtein();
		long start = System.nanoTime();
		l.distance(s1, s2);
		long duration = System.nanoTime() - start;
		System.out.println("Length 1000 equal strings duration: " + duration + " ns " + "or " + duration / 1e9 + " s.");
	}

	private static void testPerformanceUnbounded_100_Equal() {
		final int stringLength = 100;
		StringBuilder b1 = new StringBuilder();
		StringBuilder b2 = new StringBuilder();
		
		for (int i = 0; i < stringLength; i++) {
			b1.append(characters.charAt(r.nextInt(characters.length())));
			b2.append(characters.charAt(r.nextInt(characters.length())));
		}
		
		String s1 = b1.toString();
		String s2 = b2.toString();
		
		Levenshtein l = new Levenshtein();
		long start = System.nanoTime();
		l.distance(s1, s2);
		long duration = System.nanoTime() - start;
		System.out.println("Length 100 equal strings duration: " + duration + " ns " + "or " + duration / 1e9 + " s.");
	}

	private static void testPerformanceUnbounded_4() {
		Levenshtein l = new Levenshtein();
		long start = System.nanoTime();
		l.distance("Haus", "Häuser");
		long duration = System.nanoTime() - start;
		System.out.println("Kartoffelsalat-Runkelrüben unbounded duration: "+ duration + " ns " + "or " + duration / 1e9 + " s.");
	}

	private static void testPerformanceUnbounded_3() {
		Levenshtein l = new Levenshtein();
		long start = System.nanoTime();
		l.distance("Haus", "Häuser");
		long duration = System.nanoTime() - start;
		System.out.println("Haus-Häuser unbounded duration: "+ duration + " ns " + "or " + duration / 1e9 + " s.");
	}

	private static void testPerformanceUnbounded_2() {
		Levenshtein l = new Levenshtein();
		long start = System.nanoTime();
		l.distance("Haus", "Mausi");
		long duration = System.nanoTime() - start;
		System.out.println("Haus-Mausi unbounded duration: "+ duration + " ns " + "or " + duration / 1e9 + " s.");
	}

	private static void testPerformanceUnbounded_1() {
		Levenshtein l = new Levenshtein();
		long start = System.nanoTime();
		l.distance("Haus", "Maus");
		long duration = System.nanoTime() - start;
		System.out.println("Haus-Maus unbounded duration: "+ duration + " ns " + "or " + duration / 1e9 + " s.");
	}
	
    
}
