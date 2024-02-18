package org.jfree.data.test;

import org.jfree.data.Range;

public class Sandbox {
    public static void main(String[] args) {
    	Range myRange = new Range(-1, 1);
    	Range myShiftedRange = Range.shift(myRange, 2);
    	
    	double originalSize = myRange.getUpperBound() - myRange.getLowerBound();
    	double shiftedSize = myShiftedRange.getUpperBound() - myShiftedRange.getLowerBound();
        double length = myShiftedRange.getLength();
    	System.out.println("test = " + length);
        System.out.println("original size = " + originalSize);
    }
}
