package code;
import java.util.ArrayList;
import java.util.*;


public abstract class ProblemFormulation {
    ArrayList <String> operators;
    String initialState;         // initial state --> The grid

    
        
    
    abstract boolean goalTest(String state);

    abstract String getNextState(String state, String operator);

    abstract int assignPathCost(SearchTreeNode node);

}