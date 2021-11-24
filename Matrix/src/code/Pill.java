package code;
import java.util.*;

public class Pill {
    public int PillX;
    public int PillY;
    public boolean taken;

    public Pill(int[][] grid, int m, int n) {
        Random rand = new Random();
        PillX = rand.nextInt(m);
        PillY = rand.nextInt(n);
        while(grid[PillX][PillY]==1)
        {
            PillX = rand.nextInt(m);
            PillY = rand.nextInt(n);
        }
        grid[PillX][PillY] = 1;
        taken = false;
    }

    public Pill(int PillX, int PillY) {
        this.PillX = PillX;
        this.PillY = PillY;
        taken = false;
    }

    public Pill(int PillX, int PillY, boolean taken) {
        this.PillX = PillX;
        this.PillY = PillY;
        this.taken = taken;
    }
}
