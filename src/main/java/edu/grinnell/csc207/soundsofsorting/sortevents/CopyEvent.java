package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {
    private int from;
    private int dest;
    private T val;

    public CopyEvent(int from, int dest, T val) {
        this.from = from;
        this.dest = dest;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Copy value from index " + from + " to index " + dest;
    }

    @Override
    public void apply(T[] arr) {
        arr[dest] = val;
    }

    @Override
    public List<Integer> getAffectedIndices() {
        return Arrays.asList(dest);
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }
}
