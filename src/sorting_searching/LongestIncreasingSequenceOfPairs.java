package sorting_searching;

import java.util.ArrayList;
import java.util.Collections;

public class LongestIncreasingSequenceOfPairs {
    public static class HtWt implements Comparable<HtWt> {
        private int Ht;
        private int Wt;

        public HtWt(int h, int w) {
            this.Ht = h;
            this.Wt = w;
        }

        @Override
        public int compareTo(HtWt o) {
            HtWt second = (HtWt) o;
            if (this.Ht != second.Ht) {
                return this.Ht - second.Ht;
            } else {
                return this.Wt - second.Wt;
            }
        }

        public boolean isBefore(HtWt other) {
            if (this.Ht < other.Ht && this.Wt < other.Wt) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static ArrayList<HtWt> search(ArrayList<HtWt> array) {
        Collections.sort(array);
        ArrayList<HtWt>[] sols = new ArrayList[array.size()];
        for (int i = 0; i < array.size(); i++) {
            HtWt cur = array.get(i);
            ArrayList<HtWt> curBestSeq = null;
            for (int j = 0; j < i; j++) {
                if (array.get(j).isBefore(cur)) {
                    curBestSeq = seqWithMaxLength(curBestSeq, sols[j]);
                }
            }
            ArrayList<HtWt> curSol = new ArrayList<HtWt>();
            if (curBestSeq != null) {
                curSol.addAll(curBestSeq);
            }
            curSol.add(cur);
            sols[i] = curSol;
        }
        ArrayList<HtWt> globalSeq = null;
        for (int i = 0; i < array.size(); i++) {
            globalSeq = seqWithMaxLength(globalSeq, sols[i]);
        }

        return globalSeq;
    }

    private static ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
        if (seq1 == null) {
            return seq2;
        } else if (seq2 == null) {
            return seq1;
        }
        return seq1.size() > seq2.size() ? seq1 : seq2;
    }
}
