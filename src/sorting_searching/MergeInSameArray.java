package sorting_searching;

public class MergeInSameArray {
    public static void merge(int[] a, int[] b, int lenA, int lenB){
        int idxMerged = lenA + lenB - 1, idxA = lenA - 1, idxB = lenB - 1;
        while(idxB >= 0){
            if(idxA >= 0 && a[idxA] > b[idxB]){
                a[idxMerged] = a[idxA];
                idxA--;
            }else{
                a[idxMerged] = b[idxB];
                idxB--;
            }
            idxMerged--;
        }
    }
}
