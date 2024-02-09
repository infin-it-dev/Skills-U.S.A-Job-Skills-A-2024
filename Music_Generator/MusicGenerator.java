//Import MIDI and Sound 
import java.util.*;
import javax.sound.midi.*;

public class MusicGenerator {
    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException {
        // Open MIDI Sequencer
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();



                // Create sequence
                Sequence sequence = new Sequence(Sequence.PPQ, 4);

                // Create track in sequence
                Track track = sequence.createTrack();
        
                // Add MIDI to track 
                for (int i = 60; i < 72; i++) {
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