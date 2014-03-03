package zn.recursion.dp;

public class InterviewQuestions9_7 {

    enum Color {
        Black,
        White,
        Red,
        Yellow,
        Green
    }

    /**
     * This is question is about how to fill some area which has ocolor in each pixel with ncolor
     * 1. use recurisve way to solve it
     * 2. NOTE: (X, Y) in 2-D aray is screen[y][x]
     * 3. NOTE: y from 0 -> H-1 x from 0 -> H-1  
     * @param screen
     * @param x
     * @param y
     * @param ocolor
     * @param ncolor
     * @return
     */
    public static boolean paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor) {
//        return false;
        if(x < 0 || y < 0 || x >= screen[0].length || y >= screen.length)//NOTE: x-axis: screen[0].length; y-axis: screen.length
            return false;
        if(screen[y][x] == ocolor)
        {
            screen[y][x] = ncolor;
            paintFill(screen, x+1, y, ocolor, ncolor);
            paintFill(screen, x-1, y, ocolor, ncolor);
            paintFill(screen, x, y+1, ocolor, ncolor);
            paintFill(screen, x, y-1, ocolor, ncolor);
        }
        return true;
    }
    
    public static boolean paintFill(Color[][] screen, int x, int y, Color ncolor){
        if(screen[y][x] == ncolor)
            return false;
        return paintFill(screen, x, y, screen[x][y], ncolor);
    }
}
