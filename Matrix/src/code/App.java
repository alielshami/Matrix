package code;
import java.util.*;



public class App {

    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Matrix matrix = new Matrix();
        String grid = "5,5;2;4,3;2,1;2,0,0,4,0,3,0,1;3,1,3,2;4,4,3,3,3,3,4,4;4,0,17,1,2,54,0,0,46,4,1,22";
        String s = matrix.solve(grid, "UC", false);
        System.out.println(s);
        
    }
}
