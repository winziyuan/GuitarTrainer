package com.ago.guitartrainer.gridshapes;

import com.ago.guitartrainer.notation.Degree;
import com.ago.guitartrainer.notation.Note;

public class AlphaGridShape extends GridShape {

    //@formatter:off
    private static Degree[] zeroFretDegrees = new Degree[] { 
        Degree.THREE, 
        Degree.SEVEN, 
        Degree.FIVE, 
        Degree.TWO,
        Degree.SIX, 
        Degree.THREE };
    //@formatter:on

    private static int frets = 4;

    private static int[] rootStrings = new int[] { 1, 4 };

    AlphaGridShape(Note key) {
        super(zeroFretDegrees, frets, rootStrings, key);
    }

    AlphaGridShape(int suggestedFret) {
        super(zeroFretDegrees, frets, rootStrings, suggestedFret);
    }

}
