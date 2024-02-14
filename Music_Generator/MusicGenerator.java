//Import MIDI and Sound 
import java.util.*;
import javax.sound.midi.*;

public class MusicGenerator {
    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException {
        // Open MIDI Sequencer
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();



                // Create sequence
                //Change resolution to change the speed of the notes
                //Default is 4
                Sequence sequence = new Sequence(Sequence.PPQ, 4);

                // Create track in sequence
                Track track = sequence.createTrack();
        
                // Add MIDI to track 
                //Change i to change the pitch of the note
                for (int i = 35; i < 92; i++) {                                                             // Change the Value of what i is being operated on to change stagger distance
                    track.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, i, 100), i * 4));
                    track.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, i, 100), (i * 4) + 2));
                }
        
                // Set sequence in sequencer
                sequencer.setSequence(sequence);
        
                // Start playing
                sequencer.start();
        
                // Wait for sequence to finish
                while (sequencer.isRunning()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        
                // Close sequencer
                sequencer.close();


    }
}