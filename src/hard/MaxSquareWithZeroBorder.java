package hard;

public class MaxSquareWithZeroBorder {
    public static class SubSquare {
        public int topLeftX;
        public int topLeftY;
        public int edgeSize;

        public SubSquare(int topLeftX, int topLeftY, int edgeSize) {
            this.topLeftX = topLeftX;
            this.topLeftY = topLeftY;
            this.edgeSize = edgeSize;
        }
    }

    public static class SquareCell {
        public int zerosRight = 0;
        public int zerosBelow = 0;

        public SquareCell(int right, int below) {
            this.zerosRight = right;
            this.zerosBelow = below;
        }

        public void setZerosRight(int right) {
            this.zerosRight = right;
        }

        public void setZerosBelow(int below) {
            this.zerosBelow = below;
        }
    }

    /**
     * matrix must be square!
     * 
     * @param matrix
     * @return
     */
    public static SubSquare findMaxSquare(int[][] matrix) {
        SquareCell[][] processed = preprocess(matrix);
        for (int i = matrix.length; i > 0; i--) {
            SubSquare ss = search(processed, i);
            if (ss != null) {
                return ss;
            }
        }
        return null;
    }

    public static SubSquare search(SquareCell[][] processed, int size) {
        int count = processed.length - size + 1;

        for (int leftTopX = 0; leftTopX < count; leftTopX++) {
            for (int leftTopY = 0; leftTopY < count; leftTopY++) {
                if (valid(processed, leftTopX, leftTopY, size)) {
                    return new SubSquare(leftTopX, leftTopY, size);
                }
            }
        }
        return null;
    }

    public static boolean valid(SquareCell[][] processed, int leftTopX, int leftTopY, int edgeSize) {
        SquareCell topLeft = processed[leftTopX][leftTopY];
        SquareCell topRight = processed[leftTopX][leftTopY + edgeSize - 1];
        SquareCell bottomLeft = processed[leftTopX + edgeSize - 1][leftTopY];
        if (topLeft.zerosRight < edgeSize) {
            return false;
        }
        if (topLeft.zerosBelow < edgeSize) {
            return false;
        }
        if (topRight.zerosBelow < edgeSize) {
            return false;
        }
        if (bottomLeft.zerosRight < edgeSize) {
            return false;
        }
        return true;
    }

    public static SquareCell[][] preprocess(int[][] matrix) {
        SquareCell[][] processed = new SquareCell[matrix.length][matrix.length];
        for (int r = matrix.length - 1; r >= 0; r--) {
            for (int c = matrix.length - 1; c >= 0; c--) {
                int rightZeros = 0;
                int belowZeros = 0;
                if (matrix[r][c] == 0) {
                    rightZeros++;
                    belowZeros++;
                    if (c + 1 < matrix.length) {
                        SquareCell previous = processed[r][c + 1];
                        rightZeros += previous.zerosRight;
                    }
                    if (r + 1 < matrix.length) {
                        SquareCell previous = processed[r + 1][c];
                        belowZeros += previous.zerosBelow;
                    }
                }
                processed[r][c] = new SquareCell(rightZeros, belowZeros);
            }
        }
        return processed;
    }
}
