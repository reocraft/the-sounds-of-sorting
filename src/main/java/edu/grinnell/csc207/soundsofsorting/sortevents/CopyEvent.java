package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
    private int idx1;
    private int idx2;

    public CopyEvent(int idx1, int idx2, T val) {
        this.idx1 = idx1;
        this.idx2 = idx2;
    }

    @Override
    public String toString() {
        return "Copy value from index" + idx1 + " to index " + idx2;
    }

    @Override
    public void apply(T[] arr) {
        arr[idx2] = arr[idx1];
    }

    @Override
    public List<Integer> getAffectedIndices() {
        return Arrays.asList(idx2);
    }

    @Override
    public boolean isEmphasized() {
        return false;
    }
}
