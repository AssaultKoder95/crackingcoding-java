package hard;

public class ReservoirSampling {
    public static int[] solution(int[] array, int k) {
        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = array[i];
        }
        for (int i = k; i < array.length; i++) {
            int pos = (int) Math.random() * (i - 0 + 1);
            if (pos < k) {
                ans[pos] = array[i];
            }
        }
        return ans;
    }
}
