package code;
import java.util.*;

public class Agent {
    public int AgentX;
    public int AgentY;
    boolean alive;

    public Agent(int[][] grid, int m, int n) {
        Random rand = new Random();
        AgentX = rand.nextInt(m);
        AgentY = rand.nextInt(n);
        while(grid[AgentX][AgentY]==1){
            AgentX = rand.nextInt(m);
            AgentY = rand.nextInt(n);
        }
        grid[AgentX][AgentY] = 1;
        alive = true;
    }

    public Agent(int AgentX, int AgentY) {
        this.AgentX = AgentX;
        this.AgentY = AgentY;
        alive = true;
    }
    
}
