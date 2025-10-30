package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T> {
    private int idx1;
    private int idx2;

    public SwapEvent(int idx1, int idx2) {
        this.idx1 = idx1;
        this.idx2 = idx2;
    }

    @Override
    public String toString() {
        return "Swap " + idx1 + " and " + idx2;
    }

    @Override
    public List<Integer> getAffectedIndices() {
        // Return the two indices that were compared
        return Arrays.asList(idx1, idx2);
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }

    @Override
    public void apply(T[] arr) {
        T temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
