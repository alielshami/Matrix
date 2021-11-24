package code;
import java.util.*;

public class Pad {
    public int StartX;
    public int StartY;
    public int FinishX;
    public int FinishY;

    public Pad(int[][] grid, int m, int n){
        Random rand = new Random();
        StartX = rand.nextInt(m);
        StartY = rand.nextInt(n);
        while(grid[StartX][StartY]==1){
            StartX = rand.nextInt(m);
            StartY = rand.nextInt(n);
        }
        grid[StartX][StartY] = 1;

        FinishX = rand.nextInt(m);
        FinishY = rand.nextInt(n);
        while(grid[FinishX][FinishY]==1){
            FinishX = rand.nextInt(m);
            FinishY = rand.nextInt(n);
        }
        grid[FinishX][FinishY] = 1;

    }

    public Pad(int StartX, int StartY, int FinishX, int FinishY) {
        this.StartX = StartX;
        this.StartY = StartY;
        this.FinishX = FinishX;
        this.FinishY = FinishY;
    }
}
