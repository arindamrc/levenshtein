package com.quoori.levenshtein;

import static java.lang.Math.abs;

/**
 * Levenshtein distance calculator.
 * 
 * @author arc
 *
 */
public class Levenshtein {
	
	public Levenshtein() {
	}
	
    /**
     * The unbounded levenshtein algorithm.
     * 
     * @param s1 Source string.
     * @param s2 Target string.
     * @return
     */
    public int distance(String s1, String s2) {
    	if (s1 == null || s2 == null) {
			throw new IllegalArgumentException("The input string cannot be null");
		}
    	
    	if (s1.equals(s2)) {
			return 0;
		}
    	
    	int m = s1.length();
    	int n = s2.length();
    	
    	// Check for base cases.
    	if (n == 0) {
			return m;
		}
    	
    	if (m == 0) {
			return n;
		}
    	
    	// If necessary, swap the strings so that we always allocate smaller memory
    	if (m < n) {
			int swapInteger = m;
			m = n;
			n = swapInteger;
			
			String swapString = s1;
			s1 = s2;
			s2 = swapString;
		}
    	
    	// create buffers
    	int v[] = new int[n+1];
    	
    	for (int i = 1; i < m + 1; i++) {
    		char a = s1.charAt(i-1);
    		v[0] = i;
    		
    		int prev = i - 1;
    		
    		for (int j = 1; j < n + 1; j++) {
    			char b = s2.charAt(j-1);
    			
    			int cost = prev + (a == b ? 0 : 1);
    			prev = v[j]; 
    			v[j] = tripleMin(1 + v[j], 1 + v[j - 1], cost);
    		}
    		
     	}
    	
		return v[n];
    }
    
    
    
    /**
     * The k-bounded version of the Levenshtein algorithm.
     * 
     * @param s1 The source string
     * @param s2 The target string
     * @param k The bound (maxDist)
     * @return
     */
    public int distanceBounded(String s1, String s2, int k) {
    	if (s1 == null || s2 == null) {
			throw new IllegalArgumentException("The input string cannot be null");
		}
    	
    	if (k < 0) {
			throw new IllegalArgumentException("Bound cannot be negative");
		}
    	
    	if (s1.equals(s2)) {
			return 0;
		}
    	
    	int m = s1.length();
    	int n = s2.length();
    	
    	// check for base cases
    	
    	if (k >= 0 && abs(m - n) >= k) {
			return k+1;
		}
    	
    	if (m == 0) {
			return n;
		}
    	
    	if (n == 0) {
			return m;
		}
    	
    	// If necessary, swap the strings so that we always allocate smaller memory
    	if (m < n) {
			int swapInteger = m;
			m = n;
			n = swapInteger;
			
			String swapString = s1;
			s1 = s2;
			s2 = swapString;
		}
    	
    	// create the buffer
    	int v[] = new int[n+1];
    	
    	for (int i = 1; i < m + 1; i++) {
    		char a = s1.charAt(i-1);
    		v[0] = i;
    		
    		int prev = i - 1;
    		int minimum = prev;
    		
    		for (int j = 1; j < n + 1; j++) {
    			char b = s2.charAt(j-1);
    			
    			int cost = prev + (a == b ? 0 : 1);
    			prev = v[j];
    			v[j] = tripleMin(1 + v[j], 1 + v[j - 1], cost);
    			
    			if (prev < minimum) {
					minimum = prev;
				}
			}
    		
    		if (k >= 0 && minimum > k) {
				return k + 1;
			}
		}
    	
    	if (k >= 0 && v[n] > k) {
			return k + 1;
		}
    	
		return v[n];
	}
    
    
    /**
     * The recursive method is also included as a sanity check.
     * 
     * @param s1
     * @param s2
     * @return
     */
    public int distanceRecursive(String s1, String s2) {
    	if (s1.equals(s2)) {
			return 0;
		}
    	
    	int m = s1.length();
    	int n = s2.length();
    	
    	// Check for base cases.
    	if (n == 0) {
			return m;
		}
    	
    	if (m == 0) {
			return n;
		}
    	
    	return _distanceRecursive(s1, s2, m, n);
	}
    
    /**
     * Helper method to {@link Levenshtein#distanceRecursive(String, String)}.
     * 
     * @param s1
     * @param s2
     * @param m
     * @param n
     * @return
     */
    private int _distanceRecursive(String s1, String s2, int m, int n) {
    	// Check for base cases.
    	if (n == 0) {
			return m;
		}
    	
    	if (m == 0) {
			return n;
		}
    	
    	if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return _distanceRecursive(s1, s2, m - 1, n - 1);
		}
    	
    	return 1 + tripleMin(
	    			_distanceRecursive(s1, s2, m, n - 1), 
	    			_distanceRecursive(s1, s2, m - 1, n), 
	    			_distanceRecursive(s1, s2, m - 1, n - 1)
    			);
    }
    
    
    /**
     * Helper function to find the minimum of three values.
     * 
     * @param a
     * @param b
     * @param c
     * @return
     */
    private int tripleMin(int a, int b, int c) {
    	int m = a;
    	if (b < m) {
			m = b;
		}
    	if (c < m) {
			m = c;
		}
    	return m;
    }
    
}
