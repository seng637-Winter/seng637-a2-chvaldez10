package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeShiftTest {

    private Range myRange;
    private Range positiveShiftedRange;
    private Range negativeShiftedRange;
    private Range noShiftRange;
    private Range largeShiftedRange;

    @Before
    public void setUp() {
        // Initialize your ranges here
        myRange = new Range(-1, 1);
        positiveShiftedRange = Range.shift(myRange, 2);
        negativeShiftedRange = Range.shift(myRange, -2);
        noShiftRange = Range.shift(myRange, 0);
        largeShiftedRange = Range.shift(myRange, 1000000);
    }

    @Test
    public void testPositiveShiftLowerBound() {
        assertEquals("Positive shift lower bound should be 1", 1, positiveShiftedRange.getLowerBound(), .000000001d);
    }

    @Test
    public void testPositiveShiftUpperBound() {
        assertEquals("Positive shift upper bound should be 3", 3, positiveShiftedRange.getUpperBound(), .000000001d);
    }

    @Test
    public void testNegativeShiftLowerBound() {
        assertEquals("Negative shift lower bound should be -3", -3, negativeShiftedRange.getLowerBound(), .000000001d);
    }

    @Test
    public void testNegativeShiftUpperBound() {
        assertEquals("Negative shift upper bound should be -1", -1, negativeShiftedRange.getUpperBound(), .000000001d);
    }

    @Test
    public void testNoShiftLowerBound() {
        assertEquals("No shift lower bound should remain unchanged", -1, noShiftRange.getLowerBound(), .000000001d);
    }

    @Test
    public void testNoShiftUpperBound() {
        assertEquals("No shift upper bound should remain unchanged", 1, noShiftRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void shifteRemainsConstant() {
        double shiftedSize = positiveShiftedRange.getUpperBound() - positiveShiftedRange.getLowerBound();
        assertEquals("Shifted range size should remain constant",
                2.0, shiftedSize, .000000001d);
    }
    
    @Test
    public void testShiftWithLargeDelta() {
        assertEquals("Lower bound after large shift should be correct",
                999999, largeShiftedRange.getLowerBound(), .000000001d);
        assertEquals("Upper bound after large shift should be correct",
                1000001, largeShiftedRange.getUpperBound(), .000000001d);
    }
}