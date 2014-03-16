package arrays_strings;

public class InterviewQuestions1_7 {
    /**
     * FIXME this is other's solution, very smart
     * TODO use a row array and column array to mark whether this line can be set to 0
     * this algorithm is very clear, not me. I don't need add more complex logic in inner for loop
     * TODO tricky: mark 1 firstly, then set 0 later. Do not skip any elements in the inner for loop, there is pitfall in there
     * @param et1
     * @return
     */
    public static int[][] setRowColumnToZero(int[][] et1) {
        int[] row = new int[et1.length];
        int[] column = new int[et1[0].length];
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < column.length; j++) {
                if (et1[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }
        for(int i = 0 ; i < row.length; i++){
            for(int j = 0; j <column.length; j++) {
                if(row[i] == 1 || column[j] == 1)
                    et1[i][j] = 0;
            }
        }
        return et1;
    }

    public static void main(String[] args) {
        int[][] test = new int[][] { { 1, 0, 4, 6 }, { 4, 5, 9, 8}, { 7, 8, 4, 3 } };
        InterviewQuestions1_7.setRowColumnToZero(test);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
