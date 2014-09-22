package recursion_dp;

public class PaintFill {

    enum Color {
        Black,
        White,
        Red,
        Yellow,
        Green
    }

    /**
     * This is question is about how to fill a area(o_color) with n_color
     * Use recursive way to solve it
     */
    public void paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor) {
        if (x < 0 || y < 0 || x >= screen.length || y >= screen[0].length) {
            return;
        }
        if (screen[x][y] == ocolor) {
            screen[x][y] = ncolor;
            paintFill(screen, x + 1, y, ocolor, ncolor);
            paintFill(screen, x - 1, y, ocolor, ncolor);
            paintFill(screen, x, y + 1, ocolor, ncolor);
            paintFill(screen, x, y - 1, ocolor, ncolor);
        }
        return;
    }

    public void paintFill(Color[][] screen, int x, int y, Color ncolor) {
        if (screen[y][x] == ncolor) {
            return;
        }
        paintFill(screen, x, y, screen[x][y], ncolor);
    }
}
