package code;
import java.nio.file.Path;
import java.util.*;

import javax.lang.model.util.ElementScanner6;


public class PathCost implements Comparable{
    int deaths;
    int kills;

    public PathCost(int deaths, int kills) {
        this.deaths = deaths;
        this.kills = kills;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        PathCost pathCost = (PathCost) o;
        if (this.deaths>pathCost.deaths) {
            return 1;
        }
        else if (this.deaths<pathCost.deaths) {
            return -1;
        }
        else {
            if (this.kills>pathCost.kills) {
                return 1;
            }
            else if (this.kills<pathCost.kills) {
                return -1;
            }
            else {
                return 0;
            }
        }
        
        
    }
}
