/**
 * 
 */
package com.quoori.levenshtein;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author arc
 *
 */
public class LevenshteinTest {
	
	Levenshtein l;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		l = new Levenshtein();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		l = null;
	}

	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDistance_null1() {
		String s1 = "kitten";
		String s2 = null;
		l.distance(s1, s2);
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDistance_null2() {
		String s1 = null;
		String s2 = "sitting";
		l.distance(s1, s2);
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDistance_null3() {
		String s1 = null;
		String s2 = null;
		l.distance(s1, s2);
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistance_equal() {
		String s1 = "sitting";
		String s2 = "sitting";
		assertEquals(0, l.distance(s1, s2));
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistance_unityEqual() {
		String s1 = "f";
		String s2 = "f";
		assertEquals(0, l.distance(s1, s2));
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistance_unityUnEqual() {
		String s1 = "f";
		String s2 = "g";
		assertEquals(1, l.distance(s1, s2));
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistance_case1() {
		String s1 = "Haus";
		String s2 = "Maus";
		assertEquals(1, l.distance(s1, s2));
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistance_case2() {
		String s1 = "Haus";
		String s2 = "Mausi";
		assertEquals(2, l.distance(s1, s2));
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistance_case3() {
		String s1 = "Haus";
		String s2 = "Häuser";
		assertEquals(3, l.distance(s1, s2));
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistance_case4() {
		String s1 = "Kartoffelsalat";
		String s2 = "Runkelrüben";
		assertEquals(12, l.distance(s1, s2));
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistance_case5() {
		String s1 = "hhhhhhh";
		String s2 = "h";
		assertEquals(6, l.distance(s1, s2));
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistance_sanity() {
		String s1 = "Kartoffelsalat";
		String s2 = "Runkelrüben";
		assertEquals(l.distanceRecursive(s1, s2), l.distance(s1, s2));
	}
	

	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distanceBounded(java.lang.String, java.lang.String, int)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDistanceBounded_null1() {
		String s1 = "kitten";
		String s2 = null;
		l.distanceBounded(s1, s2, 20);
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distanceBounded(java.lang.String, java.lang.String, int)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDistanceBounded_null2() {
		String s1 = null;
		String s2 = "kitten";
		l.distanceBounded(s1, s2, 20);
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distanceBounded(java.lang.String, java.lang.String, int)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDistanceBounded_null3() {
		String s1 = null;
		String s2 = null;
		l.distanceBounded(s1, s2, 20);
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistanceBounded_equal() {
		String s1 = "sitting";
		String s2 = "sitting";
		assertEquals(0, l.distanceBounded(s1, s2, 20));
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistanceBounded_unityEqual() {
		String s1 = "s";
		String s2 = "s";
		assertEquals(0, l.distanceBounded(s1, s2, 20));
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistanceBounded_unityUnEqual() {
		String s1 = "s";
		String s2 = "t";
		assertEquals(1, l.distanceBounded(s1, s2, 20));
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistanceBounded_case1() {
		String s1 = "Haus";
		String s2 = "Maus";
		assertEquals(1, l.distanceBounded(s1, s2, 2));
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistanceBounded_case2() {
		String s1 = "Haus";
		String s2 = "Mausi";
		assertEquals(2, l.distanceBounded(s1, s2, 2));
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistanceBounded_case3() {
		String s1 = "Haus";
		String s2 = "Häuser";
		assertEquals(3, l.distanceBounded(s1, s2, 2));
	}
	
	/**
	 * Test method for {@link com.quoori.levenshtein.Levenshtein#distance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDistanceBounded_case4() {
		String s1 = "Kartoffelsalat";
		String s2 = "Runkelrüben";
		assertEquals(3, l.distanceBounded(s1, s2, 2));
	}
}
