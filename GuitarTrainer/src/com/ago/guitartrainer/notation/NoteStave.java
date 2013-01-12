package com.ago.guitartrainer.notation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.ago.guitartrainer.utils.MultiMap;

/**
 * The notes representation used - like, E2 - is a Scientific Pitch Notation. For the guitar, the following are the
 * notes in this notation on the strings:
 * <ul>
 * <li>The first string is E4
 * <li>The second string is B3
 * <li>The third string is G3
 * <li>The fourth string D3
 * <li>The fifth string is A2
 * <li>The sixth string is E2
 * </ul>
 * 
 * @author Andrej Golovko - jambit GmbH
 * @link http://guitar-trivia.blogspot.de/2011_06_01_archive.html
 * 
 */
public class NoteStave {

    private static NoteStave INSTANCE;
    /*-
     * the format of the array is:
     * [string][fret] 
     * 
     * The fret==0 has the meaning of "open fret".
     */
    private Note[][] notesOnFret = new Note[6][13];

    private Map<Note, List<Position>> mapNote2Positions = new Hashtable<Note, List<Position>>();

    private SortedMap<Note, Double> mapNote2Frequency = new TreeMap<Note, Double>();

    private MultiMap<Key, Octave, Note> mapKeyOctave2Note = new MultiMap<Key, Octave, Note>();

    private NoteStave() {
        initNotesOnFret();
        initNote2Freq();
    }

    public static NoteStave getInstance() {
        if (INSTANCE == null)
            INSTANCE = new NoteStave();
        return INSTANCE;
    }

    private void initNotesOnFret() {

        // E - open 1st string
        notesOnFret[0][0] = Note.E4;
        notesOnFret[0][1] = Note.F4;
        notesOnFret[0][2] = Note.F4di;
        notesOnFret[0][3] = Note.G4;
        notesOnFret[0][4] = Note.G4di;
        notesOnFret[0][5] = Note.A4;
        notesOnFret[0][6] = Note.A4di;
        notesOnFret[0][7] = Note.B4;
        notesOnFret[0][8] = Note.C5;
        notesOnFret[0][9] = Note.C5di;
        notesOnFret[0][10] = Note.D5;
        notesOnFret[0][11] = Note.D5di;
        notesOnFret[0][12] = Note.E5;

        // B - open 2nd string
        notesOnFret[1][0] = Note.B3;
        notesOnFret[1][1] = Note.C4;
        notesOnFret[1][2] = Note.C4di;
        notesOnFret[1][3] = Note.D4;
        notesOnFret[1][4] = Note.D4di;
        notesOnFret[1][5] = Note.E4;
        notesOnFret[1][6] = Note.F4;
        notesOnFret[1][7] = Note.F4di;
        notesOnFret[1][8] = Note.G4;
        notesOnFret[1][9] = Note.G4di;
        notesOnFret[1][10] = Note.A4;
        notesOnFret[1][11] = Note.A4di;
        notesOnFret[1][12] = Note.B4;

        // G - open 3rd string
        notesOnFret[2][0] = Note.G3;
        notesOnFret[2][1] = Note.G3di;
        notesOnFret[2][2] = Note.A3;
        notesOnFret[2][3] = Note.A3di;
        notesOnFret[2][4] = Note.B3;
        notesOnFret[2][5] = Note.C4;
        notesOnFret[2][6] = Note.C4di;
        notesOnFret[2][7] = Note.D4;
        notesOnFret[2][8] = Note.D4di;
        notesOnFret[2][9] = Note.E4;
        notesOnFret[2][10] = Note.F4;
        notesOnFret[2][11] = Note.F4di;
        notesOnFret[2][12] = Note.G4;

        // D - open 4th string
        notesOnFret[3][0] = Note.D3;
        notesOnFret[3][1] = Note.D3di;
        notesOnFret[3][2] = Note.E3;
        notesOnFret[3][3] = Note.F3;
        notesOnFret[3][4] = Note.F3di;
        notesOnFret[3][5] = Note.G3;
        notesOnFret[3][6] = Note.G3di;
        notesOnFret[3][7] = Note.A3;
        notesOnFret[3][8] = Note.A3di;
        notesOnFret[3][9] = Note.B3;
        notesOnFret[3][10] = Note.C3;
        notesOnFret[3][11] = Note.C3di;
        notesOnFret[3][12] = Note.D3;

        // A - open 5th string
        notesOnFret[4][0] = Note.A2;
        notesOnFret[4][1] = Note.A2di;
        notesOnFret[4][2] = Note.B2;
        notesOnFret[4][3] = Note.C3;
        notesOnFret[4][4] = Note.C3di;
        notesOnFret[4][5] = Note.D3;
        notesOnFret[4][6] = Note.D3di;
        notesOnFret[4][7] = Note.E3;
        notesOnFret[4][8] = Note.F3;
        notesOnFret[4][9] = Note.F3di;
        notesOnFret[4][10] = Note.G3;
        notesOnFret[4][11] = Note.G3di;
        notesOnFret[4][12] = Note.A3;

        // E - open 6th string
        notesOnFret[5][0] = Note.E2;
        notesOnFret[5][1] = Note.F2;
        notesOnFret[5][2] = Note.F2di;
        notesOnFret[5][3] = Note.G2;
        notesOnFret[5][4] = Note.G2di;
        notesOnFret[5][5] = Note.A2;
        notesOnFret[5][6] = Note.A2di;
        notesOnFret[5][7] = Note.B2;
        notesOnFret[5][8] = Note.C3;
        notesOnFret[5][9] = Note.C3di;
        notesOnFret[5][10] = Note.D3;
        notesOnFret[5][11] = Note.D3di;
        notesOnFret[5][12] = Note.E3;

        //
        for (int iString = 0; iString < notesOnFret.length; iString++) {
            for (int iFret = 0; iFret < notesOnFret[iString].length; iFret++) {
                Note note = notesOnFret[iString][iFret];

                if (!mapNote2Positions.containsKey(note)) {
                    mapNote2Positions.put(note, new ArrayList<Position>());
                }

                mapNote2Positions.get(note).add(new Position(iString, iFret));
            }
        }

    }

    private void initNote2Freq() {

        registerNote(Note.D2di);
        registerNote(Note.E2);
        registerNote(Note.F2);
        registerNote(Note.F2di);
        registerNote(Note.G2);
        registerNote(Note.G2di);
        registerNote(Note.A2);
        registerNote(Note.A2di);
        registerNote(Note.B2);
        registerNote(Note.C3);
        registerNote(Note.C3di);
        registerNote(Note.D3);
        registerNote(Note.D3di);
        registerNote(Note.E3);
        registerNote(Note.F3);
        registerNote(Note.F3di);
        registerNote(Note.G3);
        registerNote(Note.G3di);
        registerNote(Note.A3);
        registerNote(Note.A3di);
        registerNote(Note.B3);
        registerNote(Note.C4);
        registerNote(Note.C4di);
        registerNote(Note.D4);
        registerNote(Note.D4di);
        registerNote(Note.E4);
        registerNote(Note.F4);
        registerNote(Note.F4di);
        registerNote(Note.G4);
        registerNote(Note.G4di);
        registerNote(Note.A4);
        registerNote(Note.A4di);
        registerNote(Note.B4);
        registerNote(Note.C5);
        registerNote(Note.C5di);
        registerNote(Note.D5);
        registerNote(Note.D5di);
        registerNote(Note.E5);
        registerNote(Note.F5);

    }

    private void registerNote(Note note) {
        // TODO: add sorting to mapNote2Frequency, like it was once with the code:
        // Map<Note, Double> tmp = new Hashtable<Note, Double>();
        // mapNote2Frequency = new TreeMap(new ValueComparer(tmp));
        // mapNote2Frequency.putAll(tmp);

        mapNote2Frequency.put(note, note.getPitch());
        mapKeyOctave2Note.put(note.getKey(), note.getOctave(), note);

    }

    public Note resolveNote(double pitch) {

        /*
         * 1. resolve the closest frequency to the pitch
         */
        Note note = null;
        double prevDiff = Double.MAX_VALUE;
        Iterator<Note> i = mapNote2Frequency.keySet().iterator();
        while (i.hasNext()) {
            Note key = i.next();
            Double curr = mapNote2Frequency.get(key);
            double currDiff = curr - pitch;
            if (note == null) {
                note = key;
            } else {

                if (Math.abs(currDiff) < prevDiff) {
                    note = key;
                }
            }

            prevDiff = Math.abs(currDiff);

        }

        return note;
    }

    /** inner class to do soring of the map **/
    private class ValueComparer implements Comparator {
        private Map _data = null;

        public ValueComparer(Map data) {
            super();
            _data = data;
        }

        public int compare(Object o1, Object o2) {
            Double e1 = (Double) _data.get(o1);
            Double e2 = (Double) _data.get(o2);
            return e1.compareTo(e2);
        }
    }

    public Note resolveNote(int str, int fret) {
        return notesOnFret[str][fret];
    }

    public List<Position> resolvePositions(Note n) {
        if (mapNote2Positions.containsKey(n))
            return mapNote2Positions.get(n);
        else
            return Collections.emptyList();
    }

    public Note resolveNote(Key key, Octave octave) {
        Note note = mapKeyOctave2Note.get(key, octave);

        return note;
    }

}
