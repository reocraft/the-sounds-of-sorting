package edu.grinnell.csc207.soundsofsorting;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
   
    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * @param notes the note indices 
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Integer[] arr = notes.getNotes();
        int width = getWidth();
        int height = getHeight();
        int size = arr.length - 1;
        int barWidth = Math.max(width / size, 1);

        for (int i = 0; i < size; i++) {
            int value = arr[i];
            int barHeight = (int) ((double) value / size * height);

            int xpos = i * barWidth;
            int ypos = height - barHeight;

            if (notes.isHighlighted(i)) {
                g.setColor(java.awt.Color.GREEN);
            } else {
                g.setColor(java.awt.Color.RED);
            }

            g.fillRect(xpos, ypos, barWidth, barHeight);
        }
    }
}