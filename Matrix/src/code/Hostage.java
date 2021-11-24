package code;
import java.util.*;

public class Hostage {
    public int damage;
    public int HostageX;
    public int HostageY;
    public boolean alive;
    public boolean mutated;
    public boolean killed;
    public boolean carried;
    public boolean dropped;

    public Hostage(int[][] grid, int m, int n)
    {
        Random rand = new Random();
        damage = rand.nextInt(99)+1;
        HostageX = rand.nextInt(m);
        HostageY = rand.nextInt(n);
        while (grid[HostageX][HostageY]==1){
            HostageX = rand.nextInt(m);
            HostageY = rand.nextInt(n);
        }
        grid[HostageX][HostageY] = 1;
        mutated = false;
        alive = true;
    }

    public Hostage(int HostageX, int HostageY, int damage) {
        this.HostageX = HostageX;
        this.HostageY = HostageY;
        this.damage = damage;
        alive = true;
        mutated = false;
        killed = false;
        dropped =false;
        carried = false;
    }
}
