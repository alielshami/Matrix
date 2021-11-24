package code;
import java.util.*;

public class SearchTreeNode implements Comparable {
    String state;               // The state that this node corresponds to
    SearchTreeNode parentNode;
    String operator;            // The operator applied to generate this node
    int depth;
    PathCost pathCost;

    public SearchTreeNode(String state)
    {
        this.state = state;
        this.depth = 0;
        this.pathCost = null;
    }

    public SearchTreeNode(String state, SearchTreeNode parentNode, String operator, int depth, PathCost pathCost)
    {
        this.state = state;
        this.parentNode = parentNode;
        this.operator = operator;
        this.depth = depth;
        this.pathCost = pathCost;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        SearchTreeNode other = (SearchTreeNode) o;
        return this.pathCost.compareTo(other.pathCost);      
    }

    
}
