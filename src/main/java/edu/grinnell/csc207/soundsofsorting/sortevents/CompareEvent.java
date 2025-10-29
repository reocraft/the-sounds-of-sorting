package edu.grinnell.csc207.soundsofsorting.sortevents;
import java.util.Arrays;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> implements SortEvent<T> {
    private int idx1;
    private int idx2;

    public CompareEvent(int idx1, int idx2) {
        this.idx1 = idx1;
        this.idx2 = idx2;
    }

    @Override
    public String toString() {
        return "Compare " + idx1 + " vs " + idx2;
    }

    @Override
    public List<Integer> getAffectedIndices() {
        // Return the two indices that were compared
        return Arrays.asList(idx1, idx2);
    }

    @Override
    public boolean isEmphasized() {
        return false;
    }

    @Override
    public void apply(T[] arr) {
        return;
    }
}
