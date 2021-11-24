package code;
import java.util.*;



public class Matrix extends ProblemFormulation{
    String grid;
    String state;;
    Neo Neo;
    ArrayList<Hostage> hostages;
    int TelephoneX;
    int TelephoneY;
    ArrayList<Pill> pills;
    ArrayList<Agent> agents;
    ArrayList<Pad> pads;
    int m;
    int n;
    int gridSize;
    int c;
    int deaths;
    int kills;

    //ArrayList <Hostage> carriedHostages = new ArrayList<Hostage>();
    public Matrix(){

    }

    /*public void genGrid() 
    {
        String s = "";

        Random rand = new Random();
  
        // Generate random integers in range 0 to 999
        //this.m = rand.nextInt(11)+5;
        //this.n = rand.nextInt(11)+5;
        this.m = 3;
        this.n = 3;
        this.gridSize = m*n;

        //Pair[] takenLocations = new Pair[m*n];
        int pair[][] = new int [m][n];


        s += m;
        s += ",";
        s += n;
        s += "; ";
  
        // Print random integers
        System.out.println("Grid width "+m);
        System.out.println("Grid Height: "+n);

        // Generate maximum number of hostages carried at a time
        this.c = rand.nextInt(5);

        s += c +"; ";

        System.out.println("C: "+c);

        // Generate Neo's location 
        //this.NeoX = rand.nextInt(m);
        //this.NeoY = rand.nextInt(n);
        //pair[NeoX][NeoY] = 1;

        //s += NeoX + ",";

        //s += NeoY + "; "; 

        gridSize--;
        // Print Neo's location
        //System.out.println("Neo's location x: "+ NeoX);
        //System.out.println("Neo's location y: "+ NeoY);

        // Generate telephone booth location
        TelephoneX = rand.nextInt(m);
        TelephoneY = rand.nextInt(n);
        while (pair[TelephoneX][TelephoneY] == 1) {
            TelephoneX = rand.nextInt(m);
            TelephoneY = rand.nextInt(n);

        }
        pair[TelephoneX][TelephoneY] = 1;
        gridSize--;

        s += TelephoneX + "," + TelephoneY + "; ";

        // Print telephone location
        System.out.println("Telephone's location x: "+ TelephoneX);
        System.out.println("Telephone's location y: "+ TelephoneY);

        // Generate pills location
        // w : maximum number of hostages, p: maximum number of pills
        int w = rand.nextInt(8) + 3 ;

        int p =  rand.nextInt(w+1);
        String s4 = "";

        this.pills= new Pill[p];  

        for (int i = 0 ; i < p ; i++) {
            Pill P = new Pill(pair,m,n);
            gridSize--;
            pills[i] = P;
            s4 += P.PillX + "," + P.PillY;
            if (i==p-1)
            {
                s4+="; ";
            }
            else
            {
                s4+=",";
            }
        }

        // Generate random hostages
        
        System.out.println("w: "+ w);
        String s3 = "";
        String s5 = "";

        this.hostages= new Hostage[w];  

        for (int i = 0 ; i < w ; i++) {
            Hostage H = new Hostage(pair,m,n);
            gridSize--;
            hostages[i] = H;
            s3 += H.HostageX + "," + H.HostageY + "," + H.damage;
            s5 += H.HostageX + "," + H.HostageY + "," + H.damage;
            s5 += H.alive? "1" : "0" ;
            if (i!=w-1){
                s3+=",";
                s5+=",";
            }
            
        }

        // Generate random Agents
        int k = rand.nextInt(gridSize/2);
        System.out.println("k: "+k);
        String s1 = "";

        this.agents = new Agent[k];
        for (int i = 0 ; i < k ; i++) {
            Agent A = new Agent(pair,m,n);
            gridSize--;
            agents[i] = A;
            s1 += A.AgentX+ "," + A.AgentY;
            if (i==k-1)
            {
                s1+="; ";
            }
            else
            {
                s1+=",";
            }
        }

        // Generate random Pads
        String s2 = "";
        if (gridSize>1) {
            int pds = rand.nextInt(gridSize/2);
        System.out.println("Pads: "+pds);
        

        this.pads = new Pad[pds];
        for (int i = 0 ; i < pds ; i++) {
            Pad pad = new Pad(pair,m,n);
            gridSize-=2;
            pads[i] = pad;
            s2 += pad.StartX+ "," + pad.StartY + "," + pad.FinishX + "," + pad.FinishY + "," + pad.FinishX + "," + pad.FinishY +"," + pad.StartX + "," + pad.StartY;
            if (i==pds-1)
            {
                s2+="; ";
            }
            else
            {
                s2+=",";
            }
        }

        }
        

        s += s1;
        s += s4;
        s += s2;
        s += s3;
        this.grid = s;
        this.state = s1+s2+s3+s5;

        /*for(int i = 0 ; i < w ; i++) {
            System.out.println("Hostage "+(i+1)+ ": " + hostages[i]);
        }
        for(int i = 0 ; i < p ; i++) {
            System.out.println("Pill "+(i+1)+ ": " + pills[i]);
        }
        for(int i = 0 ; i < k ; i++) {
            System.out.println("Agent "+(i+1)+ ": " + agents[i]);
        }
        for(int i = 0 ; i < pds ; i++) {
            System.out.println("Pad "+(i+1)+ ": " + pads[i]);
        }*/


        //System.out.println(this.grid);
        //return this.grid;
  
        
   // }
    

    public String genGrid(String grid) {
        String[] arr = grid.split(";");

        // grid size (m,n)
        String[] gridSize = arr[0].split(",");
        m = Integer.parseInt(gridSize[0]);
        n = Integer.parseInt(gridSize[1]);

        // c
        c = Integer.parseInt(arr[1]);

        // Neo Location
        String[] NeoLoc = arr[2].split(",");
        int NeoX = Integer.parseInt(NeoLoc[0]);
        int NeoY = Integer.parseInt(NeoLoc[1]);

        Neo = new Neo(NeoX,NeoY,0,0);

        // Telephone Booth location
        String[] boothLoc = arr[3].split(",");
        TelephoneX = Integer.parseInt(boothLoc[0]);
        TelephoneY = Integer.parseInt(boothLoc[1]);

        // Agents' locations
        String[] agentsInfo = arr[4].split(",");
        this.agents = new ArrayList<Agent>();
        for (int i=0; i<agentsInfo.length; i=i+2) {
            int agentX = Integer.parseInt(agentsInfo[i]);
            int agentY = Integer.parseInt(agentsInfo[i+1]);
            Agent A = new Agent(agentX, agentY);
            this.agents.add(A);
        }

        // Pills' location
        String[] pillsInfo = arr[5].split(",");
        this.pills = new ArrayList<Pill>();
        for (int i=0; i<pillsInfo.length; i=i+2) {
            int pillX = Integer.parseInt(pillsInfo[i]);
            int pillY = Integer.parseInt(pillsInfo[i+1]);
            Pill P = new Pill(pillX, pillY);
            this.pills.add(P);
        }

        // Pad's location
        String[] padsInfo = arr[6].split(",");
        this.pads = new ArrayList<Pad>();
        for(int i=0; i<padsInfo.length; i=i+8) {
            int startX = Integer.parseInt(padsInfo[i]);
            int startY = Integer.parseInt(padsInfo[i+1]);
            int finishX = Integer.parseInt(padsInfo[i+2]);
            int finishY = Integer.parseInt(padsInfo[i+3]);
            Pad pad = new Pad(startX, startY, finishX, finishY);
            this.pads.add(pad);
        }

        
        // Hostages' locations
        String[] hostagesInfo = arr[7].split(",");
        this.hostages = new ArrayList<Hostage>();
        for(int i=0; i<hostagesInfo.length; i=i+3) {
            int hostageX = Integer.parseInt(hostagesInfo[i]);
            int hostageY = Integer.parseInt(hostagesInfo[i+1]);
            int d = Integer.parseInt(hostagesInfo[i+2]);
            Hostage H = new Hostage(hostageX, hostageY, d);
            this.hostages.add(H);
            //System.out.println(hostages[i/3].damage);
        }

        deaths = 0;
        kills = 0;
        
        return formulateString();

        //this.currentC = this.c - this.carriedHostages.size();
        
    }

    public void populateGrid(String grid) {
        String[] arr = grid.split(";");

        // grid size (m,n)
        String[] gridSize = arr[0].split(",");
        m = Integer.parseInt(gridSize[0]);
        n = Integer.parseInt(gridSize[1]);

        // c
        c = Integer.parseInt(arr[1]);

        // Neo Location
        String[] NeoInfo = arr[2].split(",");
        int NeoX = Integer.parseInt(NeoInfo[0]);
        int NeoY = Integer.parseInt(NeoInfo[1]);
        int c = Integer.parseInt(NeoInfo[2]);
        int damage = Integer.parseInt(NeoInfo[3]);
        Neo = new Neo(NeoX, NeoY, c, damage);

        // Telephone Booth location
        String[] boothLoc = arr[3].split(",");
        TelephoneX = Integer.parseInt(boothLoc[0]);
        TelephoneY = Integer.parseInt(boothLoc[1]);

        // Agents' locations
        String[] agentsInfo = arr[4].split(",");
        this.agents = new ArrayList<Agent>();
        for (int i=0; i<agentsInfo.length; i=i+3) {
            int agentX = Integer.parseInt(agentsInfo[i]);
            int agentY = Integer.parseInt(agentsInfo[i+1]);
            int alive = Integer.parseInt(agentsInfo[i+2]);
            Agent A = new Agent(agentX, agentY);
            if (alive == 0) 
                A.alive = false;
            else
                A.alive = true;
            this.agents.add(A);
        }

        // Pills' location
        String[] pillsInfo = arr[5].split(",");
        this.pills = new ArrayList<Pill>();
        for (int i=0; i<pillsInfo.length; i=i+3) {
            int pillX = Integer.parseInt(pillsInfo[i]);
            int pillY = Integer.parseInt(pillsInfo[i+1]);
            int taken = Integer.parseInt(pillsInfo[i+2]);
            boolean t;
            if (taken == 1) {
                t = true;
            }
            else {
                t = false;
            }
            Pill P = new Pill(pillX, pillY,t);
            
            this.pills.add(P);
        }

        // Pad's location
        String[] padsInfo = arr[6].split(",");
        this.pads = new ArrayList<Pad>();
        for(int i=0; i<padsInfo.length; i=i+8) {
            int startX = Integer.parseInt(padsInfo[i]);
            int startY = Integer.parseInt(padsInfo[i+1]);
            int finishX = Integer.parseInt(padsInfo[i+2]);
            int finishY = Integer.parseInt(padsInfo[i+3]);
            Pad pad = new Pad(startX, startY, finishX, finishY);
            this.pads.add(pad);
        }

        //if(arr.length==8) {
        // Hostages' locations
        String[] hostagesInfo = arr[7].split(",");
        this.hostages = new ArrayList<Hostage>();
        for(int i=0; i<hostagesInfo.length; i=i+8) {
            int hostageX = Integer.parseInt(hostagesInfo[i]);
            int hostageY = Integer.parseInt(hostagesInfo[i+1]);
            int d = Integer.parseInt(hostagesInfo[i+2]);
            int carried = Integer.parseInt(hostagesInfo[i+3]);
            int dropped = Integer.parseInt(hostagesInfo[i+4]);
            int alive = Integer.parseInt(hostagesInfo[i+5]);
            int mutated = Integer.parseInt(hostagesInfo[i+6]);
            int killed = Integer.parseInt(hostagesInfo[i+7]);
            Hostage H = new Hostage(hostageX, hostageY, d);
            if (carried == 1) {
                H.carried = true;
            }   
            else
                H.carried = false;
            
            if (dropped == 1)
                H.dropped = true;
            else 
                H.dropped = false;
            if (alive == 1)
                H.alive = true;
            else
                H.alive = false;
            if (mutated == 1)
                H.mutated = true;
            else
                H.mutated = false;
            if (killed == 1)
                H.killed = true;
            else
                H.killed = false;                            
            this.hostages.add(H);
        }

        this.deaths = 0;
        this.kills = 0;
        for (Hostage H: hostages) {
            if (!H.alive) {
                this.deaths++;
            }
            if (H.mutated) {
                this.kills++;
            }
        }

        for (Agent A: agents) {
            if(!A.alive) {
                this.kills++;
            }
        }



        //}
        /*else {
            if(arr.length==9) {
                // Hostages' locations
                String[] info1 = arr[7].split(",");
                //String[] info2 = arr[8].split(",");
                String m = arr[7]+","+arr[8];
                if(m.charAt(0)==',') {
                    m = m.substring(1);
                }
                String[] hostagesInfo = (m).split(",");
                System.out.println(m);

                this.hostages = new Hostage[hostagesInfo.length/3];
                for(int i=0; i<hostagesInfo.length; i=i+3) {
                    
                    int hostageX = Integer.parseInt(hostagesInfo[i]);
                    int hostageY = Integer.parseInt(hostagesInfo[i+1]);
                    int d = Integer.parseInt(hostagesInfo[i+2]);
                    Hostage H = new Hostage(hostageX, hostageY, d);
                    this.hostages[i/3] = H;
                    //System.out.println(hostages[i/3].damage);
                    if(i>=info1.length) {
                        this.carriedHostages.add(H);
                    }
                }
            
            
            }
        }*/

        //this.currentC = this.c - this.carriedHostages.size();
        
    }

    public String solve(String grid, String strategy, boolean visualize) {

        
        
        //switch(strategy) {
            //case "BF" : 
                //SearchTreeNode node = solveBF(grid);
            //case "DF" :
                //return solveDF(grid);
            //case "ID" :
                //return solveID(grid);
            //case "UC" :
                //return solveUC(grid);
        //}
        SearchTreeNode node = null;
        if (strategy=="BF") {
            node = solveBF(grid);
        }
        if (strategy=="DF") {
            node = solveDF(grid);
        }
        if (strategy=="UC") {
            node = solveUC(grid);
        }
        String s = "";

        int numberOfNodes = 1;

        while(node.parentNode != null) {
            s += node.operator+",";
            node = node.parentNode;
            numberOfNodes ++;
        }
        s = s.substring(0, s.length()-1);

        String[] s1 = s.split(",");
        String[] s2 = new String[s1.length];
        int j = 0;
        for (int i=s1.length-1; i>=0 ; i--) {
            s2[j] = s1[i];
            j++;
        }
        String last = String.join(",", s2);
        last += ",";
        

        /*this.deaths = 0;
        this.kills = 0;
        for (Hostage H: hostages) {
            if (!H.alive) {
                this.deaths++;
            }
            if (H.mutated) {
                this.kills++;
            }
        }

        for (Agent A: agents) {
            if(!A.alive) {
                this.kills++;
            }
        }*/

        last += deaths + ";";
        last += kills + ";";
        last += numberOfNodes + "";
        
        return last;
    }

    public SearchTreeNode solveBF(String grid) {

        // generate our grid and populate our classes and arrays
        String initalState = genGrid(grid);

        SearchTreeNode root = new SearchTreeNode(initalState);

        this.initialState = initalState;

        this.operators = new ArrayList<String>();

        this.operators.add("drop");
        this.operators.add("carry");
        this.operators.add("kill");
        this.operators.add("fly");
        this.operators.add("takePill");
        this.operators.add("up");
        this.operators.add("down");
        this.operators.add("left");
        this.operators.add("right");

        Queue<SearchTreeNode> nodes = new LinkedList<>();
        HashSet<String> h = new HashSet<String>();

        nodes.add(root);
        String newState = formulateStringWithoutDamage();
        h.add(newState);
        while (!nodes.isEmpty()) {
            SearchTreeNode node = nodes.remove();
            
            System.out.println("depth:" +node.depth);

            if (goalTest(node.state)) {
                System.out.println(node.state);
                return node;
            }
            else {
                for (String operator: operators) {
                    
                    String nextState = getNextState(node.state, operator);
                    if (!(nextState==null)) {
                        newState = formulateStringWithoutDamage();
                        if (!h.contains(newState)) {
                            h.add(nextState);
                            PathCost pathCost = new PathCost(deaths,kills);
                            SearchTreeNode Node = new SearchTreeNode(nextState, node, operator, node.depth+1, pathCost);
                            nodes.add(Node);
                        }
                    }
                }
            }
        }


        return null;
    }

    public SearchTreeNode solveDF(String grid) {

        // generate our grid and populate our classes and arrays
        String initalState = genGrid(grid);

        SearchTreeNode root = new SearchTreeNode(initalState);

        this.initialState = initalState;

        this.operators = new ArrayList<String>();

        this.operators.add("drop");
        this.operators.add("carry");
        this.operators.add("kill");
        this.operators.add("fly");
        this.operators.add("takePill");
        this.operators.add("up");
        this.operators.add("down");
        this.operators.add("left");
        this.operators.add("right");

        Stack<SearchTreeNode> stack = new Stack<SearchTreeNode>();
        HashSet<String> h =  new HashSet<String>();

        stack.push(root);
        h.add(root.state);

        while (!stack.isEmpty()) {
            SearchTreeNode node = stack.pop();
            //populateGrid(node.state);
            System.out.println("depth:" +node.depth);

            if (goalTest(node.state)) {
                System.out.println(node.state);
                return node;
            }
            else {
                for (String operator: operators) {
                    
                    String nextState = getNextState(node.state, operator);
                    if (!(nextState==null)) {
                        if (!h.contains(nextState)) {
                            h.add(nextState);
                            PathCost pathCost = new PathCost(deaths,kills);
                            SearchTreeNode Node = new SearchTreeNode(nextState, node, operator, node.depth+1, pathCost);
                            stack.push(Node);
                        }
                        else {
                        	System.out.println("here");
                        }
                    }
                }
            }

        }

        return null;
    }

    public String solveID(String grid) {

        return "";
    }

    public SearchTreeNode solveUC(String grid) {

        // generate our grid and populate our classes and arrays
        String initalState = genGrid(grid);

        SearchTreeNode root = new SearchTreeNode(initalState);

        this.initialState = initalState;

        this.operators = new ArrayList<String>();

        this.operators.add("drop");
        this.operators.add("carry");
        this.operators.add("kill");
        this.operators.add("fly");
        this.operators.add("takePill");
        this.operators.add("up");
        this.operators.add("down");
        this.operators.add("left");
        this.operators.add("right");
        
        PriorityQueue<SearchTreeNode> pq = new PriorityQueue<SearchTreeNode>();

        HashSet<String> h =  new HashSet<String>();

        pq.add(root);
        h.add(root.state);

        while (!pq.isEmpty()) {
            SearchTreeNode node = pq.remove();
            //populateGrid(node.state);
            System.out.println("depth:" +node.depth);

            if (goalTest(node.state)) {
                System.out.println(node.state);
                return node;
            }
            else {
                for (String operator: operators) {
                    
                    String nextState = getNextState(node.state, operator);
                    if (!(nextState==null)) {
                        if (!h.contains(nextState)) {
                            h.add(nextState);
                            PathCost pathCost = new PathCost(deaths,kills);
                            SearchTreeNode Node = new SearchTreeNode(nextState, node, operator, node.depth+1, pathCost);
                            pq.add(Node);
                        }
                    }
                }
            }

        }


        return null;
    }

    
    

    @Override
    public boolean goalTest(String state) {
        // TODO Auto-generated method stub
        
            //System.out.println(state);
        populateGrid(state);
            
       

        boolean neoAtBooth = false;
        boolean hostagesAtbooth = true;

        if(Neo.NeoX == this.TelephoneX && Neo.NeoY == this.TelephoneY) {
            neoAtBooth = true;
        }

        for (Hostage H : hostages) {
            if (H.mutated) {
                if (!H.killed) {
                    hostagesAtbooth = false;
                    break;
                }
            }
            else if (!(H.HostageX == TelephoneX && H.HostageY == TelephoneY) || H.carried) {
                hostagesAtbooth = false;
                break;
            }
        }

        
        return neoAtBooth && hostagesAtbooth;

        /*
        String[] arrOfState = state.split(";");

        String neo = arrOfState[2];
        String telephone = arrOfState[3];
        String hostages = arrOfState[arrOfState.length -1];

        if (!neo.equals(telephone))
            return false;
        
        String[] telLocation = telephone.split(",");
        int telX = Integer.parseInt(telLocation[0]);
        int telY = Integer.parseInt(telLocation[1]);
        
        String[] hostagesInfo = hostages.split(",");
        for (int i = 0; i < hostagesInfo.length; i+=4)
        {
            int x1 = Integer.parseInt(hostagesInfo[i]);
            int y1 = Integer.parseInt(hostagesInfo[i+1]);
            int damage = Integer.parseInt(hostagesInfo[i+2]);
            int alive = Integer.parseInt(hostagesInfo[i+3]);

            if (!(x1 == telX && y1 == telY)) {
                if (damage >= 100) {
                    if (alive == 1) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            
        }
        */
        
    }

    @Override
    String getNextState(String state, String operator) {
        // Auto-generated method stub
        populateGrid(state);
            
        if (operator == "up") {
            if (Neo.NeoX == 0) {
                return null;
            }
            else {
                for (Agent A : agents) {
                    if (Neo.NeoX == A.AgentX + 1 && Neo.NeoY == A.AgentY && A.alive) {
                        return null;
                    }

                }
                    
                
                for (Hostage H : hostages){
                    if (Neo.NeoX == H.HostageX + 1 && Neo.NeoY == H.HostageY) {
                        if(H.mutated) {
                            if(!H.killed) {
                                return null;
                            }
                        }
                        if(H.damage>=98) {
                            return null;
                        }
                    } 
                }
                Neo.NeoX --;
                //  change Neo's location in the state and the grid strings
                incurDamage(); // increase damage of hostages after this action
                carriedHostageFollowNeo();
                return formulateString();
            }
        } 

        if (operator == "down") {
            if (Neo.NeoX == this.m - 1) {
                return null;
            }
            else {
                for (Agent A : agents) {
                    if (Neo.NeoX == A.AgentX - 1 && Neo.NeoY == A.AgentY && A.alive) {
                        return null;
                    }

                }

                for (Hostage H : hostages){
                    if (Neo.NeoX == H.HostageX - 1 && Neo.NeoY == H.HostageY) {
                        if(H.mutated) {
                            if(!H.killed) {
                                return null;
                            }
                        }
                        if(H.damage>=98) {
                            return null;
                        }
                    } 
                }
                
                Neo.NeoX ++;
                //  change Neo's location in the state and the grid strings  
                incurDamage(); // increase damage of hostages after this action  
                carriedHostageFollowNeo();
                return formulateString();  
            }
            
        }

        if (operator == "left") {
            if (Neo.NeoY == 0) {
                return null;
                
            }
            else {
                for (Agent A : agents) {
                    if (Neo.NeoX == A.AgentX && Neo.NeoY == A.AgentY + 1 && A.alive) {
                        return null;
                    }

                } 
                for (Hostage H : hostages){
                    if (Neo.NeoX == H.HostageX && Neo.NeoY == H.HostageY + 1) {
                        if(H.mutated) {
                            if(!H.killed) {
                                return null;
                            }
                        }
                        if(H.damage>=98) {
                            return null;
                        }
                    } 
                }
                Neo.NeoY --;
                //  change Neo's location in the state and the grid strings
                incurDamage(); // increase damage of hostages after this action
                carriedHostageFollowNeo();
                return formulateString();  
            }
        }

        if (operator == "right") {
            if (Neo.NeoY == this.n-1) {
                return null;
            }
            else {
                for (Agent A : agents) {
                    if (Neo.NeoX == A.AgentX && Neo.NeoY == A.AgentY - 1 && A.alive) {
                        return null;
                    }

                } 
                for (Hostage H : hostages){
                    if (Neo.NeoX == H.HostageX && Neo.NeoY == H.HostageY - 1) {
                        if(H.mutated) {
                            if(!H.killed) {
                                return null;
                            }
                        }
                        if(H.damage>=98) {
                            return null;
                        }
                    } 
                }

                Neo.NeoY ++;
                // change Neo's location in the state and the grid strings
                incurDamage(); // increase damage of hostages after this action
                carriedHostageFollowNeo();
                return formulateString(); 
            }
        }
        if (operator == "carry") {
            boolean hostageFound = false;
            if(Neo.c < c) {
                for (Hostage H : hostages) {
                    if (Neo.NeoX == H.HostageX && Neo.NeoY == H.HostageY) {
                        if (H.alive) {
                            if (!H.carried) {
                                if (!H.dropped) {
                                    Neo.c++;
                                    hostageFound = true;
                                    H.carried = true;
                                    incurDamage();
                                    carriedHostageFollowNeo();
                                    return formulateString();
                                }
                            }
                        }
                    }
                }
                if (!hostageFound) {
                    return null;
                }
            }
            else {
                return null;
            }
        }
        
        if (operator == "drop") {
            if (Neo.c == 0) {
                return null;
            }
            else {
                boolean hostagesFound = false;
                if (Neo.NeoX == this.TelephoneX && Neo.NeoY == this.TelephoneY) {
                    for (Hostage H : hostages) {
                        if(H.carried) {
                            hostagesFound = true;
                            H.HostageX = TelephoneX;
                            H.HostageY = TelephoneY;
                            H.dropped = true;
                            H.carried = false;
                        }
                        // change hostage location in the state and grid string
                        
                    }
                    if (hostagesFound) {
                        Neo.c = 0;
                        incurDamage();
                        return formulateString();
                    }
                        
                    else 
                        return null;    
                }
                else 
                    return null;
            }
        }

        if (operator == "takePill") {
            boolean pillFound = false;
            for (Pill p : pills) {
                if (Neo.NeoX == p.PillX && Neo.NeoY == p.PillY && !p.taken) {
                    pillFound = true;
                    p.taken = true;
                    break;
                }
            }
            if (pillFound) {
                // decrease damage of neo and hostages by 20
                decreaseDamage();
                // change the damage of hostages in the state and grid strings
                carriedHostageFollowNeo();
                return formulateString();
            }
            else {
                return null;
            }
        }

        if (operator == "kill") {
            if (Neo.damage>=80) {
                return null;
            }
            int agentsNo = 0;
            for (Hostage H : hostages) {
                if(H.HostageX == Neo.NeoX && H.HostageY == Neo.NeoY && H.damage >= 98) {
                    return null;
                }
            }
            for (Agent A : agents) {
                if(A.AgentX == Neo.NeoX - 1 && A.AgentY == Neo.NeoY) {
                    // Agent above Neo
                    A.alive = false;
                    agentsNo ++;
                }
                if(A.AgentX == Neo.NeoX + 1 && A.AgentY == Neo.NeoY) {
                    // Agent beneath Neo
                    A.alive = false;
                    agentsNo ++;
                }
                if(A.AgentX == Neo.NeoX && A.AgentY == Neo.NeoY - 1) {
                    // Agent at the left of Neo
                    A.alive = false;
                    agentsNo ++;
                }
                if(A.AgentX == Neo.NeoX && A.AgentY == Neo.NeoY + 1) {
                    // Agent at the right of Neo
                    A.alive = false;
                    agentsNo ++;
                }
                             
            }
            for (Hostage H : hostages) {
                if(H.mutated && !H.killed && H.HostageX == Neo.NeoX - 1 && H.HostageY == Neo.NeoY) {
                    // mutated hostage above Neo
                    H.killed = true;
                    agentsNo ++;
                }
                if(H.mutated && !H.killed && H.HostageX == Neo.NeoX + 1 && H.HostageY == Neo.NeoY) {
                    // Mutated Hostage beneath Neo
                    H.killed = true;
                    agentsNo ++;
                }
                if(H.mutated && !H.killed && H.HostageX == Neo.NeoX && H.HostageY == Neo.NeoY - 1) {
                    // Mutated Hotsage at the left of Neo
                    H.killed = true;
                    agentsNo ++;
                }
                if(H.mutated && !H.killed && H.HostageX == Neo.NeoX && H.HostageY == Neo.NeoY + 1) {
                    // Mutated Hostage at the right of Neo
                    H.killed = true;
                    agentsNo ++;
                }
                             
            }
            if (agentsNo==0) {
                return null;
            }
            else {
                Neo.damage += 20;
                incurDamage();
                carriedHostageFollowNeo();
                return formulateString();
            }
        }

        if (operator == "fly") {
            for (Pad p : pads) {
                if (Neo.NeoX == p.StartX && Neo.NeoY == p.StartY) {
                    Neo.NeoX = p.FinishX;
                    Neo.NeoY = p.FinishY;
                    incurDamage();
                    carriedHostageFollowNeo();
                    return formulateString();
                }
                else {
                    if (Neo.NeoX == p.FinishX && Neo.NeoY == p.FinishY) {
                        Neo.NeoX = p.StartX;
                        Neo.NeoY = p.StartY;
                        incurDamage();
                        carriedHostageFollowNeo();
                        return formulateString();
                    }
                }
            }

            return null;
        }    
        




        
        return null;
    }

    @Override
    int assignPathCost(SearchTreeNode node) {
        // TODO Auto-generated method stub
        return 0;
    }
    public String changeState(String state, int NeoX, int NeoY) {
        String[] s = state.split(";");
        s[2] = ""+NeoX+","+NeoY;
        String newState = String.join(";", s);
        return newState;
    }
    public String changeState(String state, int c) {
        String[] s = state.split(";");
        s[1] = ""+c;
        String newState = String.join(";", s);
        return newState;
    }
    public String changeState(String state, int c,int hX, int hY) {
        String[] s = state.split(";");
        s[1] = ""+c;
        String[] s1 = s[7].split(",");
        s[7] = "";
        for (int i=0; i<s1.length; i=i+3) {
            hX = Integer.parseInt(s1[i]);
            hY = Integer.parseInt(s1[i+1]);
            int dH = Integer.parseInt(s1[i+2]);
            if (!(Neo.NeoX == hX && Neo.NeoY == hY)) {
                s[7] += hX +","+hY+","+dH+",";
            }
        }
        s[7] = s[7].substring(0, s[7].length()-1);
        String newState = String.join(";", s);
        return newState;
    }

    public void incurDamage() {
        for( Hostage H : hostages ) {
            if (!(H.HostageX == TelephoneX && H.HostageY == TelephoneY)) {
                H.damage = H.damage<=98 ? H.damage+2 : 100;
                if (H.damage == 100) {
                    H.alive = false;
                    if (!H.carried) {
                        if (!H.dropped) {
                            H.mutated = true;
                            H.killed = false;
                        }

                    }
                }
            }
        }
    }

    public void decreaseDamage() {
        Neo.damage = Neo.damage>=20? Neo.damage-= 20 : 0;
        for (Hostage H : hostages) {
            if (H.alive) {
                H.damage = H.damage>=20? H.damage-= 20 : 0;
            }
            
        }
    }

    public void carriedHostageFollowNeo(){
        if (Neo.c != 0) {
            for (Hostage H : hostages) {
                if(H.carried){
                    H.HostageX = Neo.NeoX;
                    H.HostageY = Neo.NeoY;
                }
            }
        }

    }
    
    public String formulateString() {
        String s = "";
        s += m + "," + n + ";";
        s += c + ";";
        s += Neo.NeoX + "," + Neo.NeoY +"," + Neo.c + "," + Neo.damage + ";";
        s += TelephoneX + "," + TelephoneY + ";";
        for (Agent A : agents) {
            s += A.AgentX + "," + A.AgentY + "," ;
            if (A.alive) {
                s += "1,";
            }
            else {
                s += "0,";
            }
        }
        if (s.charAt(s.length()-1)==',') {
            s = s.substring(0, s.length()-1);
        }

        s += ";";

        for (Pill p : pills) {
            s += p.PillX + "," + p.PillY + ",";
            if (p.taken) {
                s += '1' + ",";
            }
            else {
                s += '0' + ",";
            }
        }

        if (s.charAt(s.length()-1)==',') {
            s = s.substring(0, s.length()-1);
        }

        s += ";";

        for (Pad pad : pads) {
            s += pad.StartX+ "," + pad.StartY + "," + pad.FinishX + "," + pad.FinishY + "," + pad.FinishX + "," + pad.FinishY +"," + pad.StartX + "," + pad.StartY + ",";
        }

        if (s.charAt(s.length()-1)==',') {
            s = s.substring(0, s.length()-1);
        }

        s += ";";

        for (Hostage H : hostages) {
           
            s += H.HostageX + "," + H.HostageY + "," + H.damage + ",";
            if(H.carried) {
                s += "1,";
            }
            else {
                s += "0,";
            }
            if (H.dropped) {
                s += "1,";
            }
            else {
                s += "0,";
            }
            if(H.alive) {
                s += "1,";
            }
            else {
                s += "0,";
            }
            if (H.mutated) {
                s += "1,";
            }
            else {
                s += "0,";
            }
            if (H.killed) {
                s += "1,";
            }
            else {
                s += "0,";
            }

        }

        if (s.charAt(s.length()-1)==',') {
            s = s.substring(0, s.length()-1);
        }

        /*if (!carriedHostages.isEmpty()) {
            s += ";";

            for (int i=0; i<this.hostages.length; i++) {
                if (this.hostages[i].carried) {
                    s += this.hostages[i].HostageX + "," + this.hostages[i].HostageY + "," + this.hostages[i].damage + ",";
                }
            }

            if (s.charAt(s.length()-1)==',') {
                s = s.substring(0, s.length()-1);
            }

        }*/
        
        return s;
    }
    public String formulateStringWithoutDamage() {
        String s = "";
        s += m + "," + n + ";";
        s += c + ";";
        s += Neo.NeoX + "," + Neo.NeoY +"," + Neo.c + ";";
        s += TelephoneX + "," + TelephoneY + ";";
        for (Agent A : agents) {
            s += A.AgentX + "," + A.AgentY + "," ;
            if (A.alive) {
                s += "1,";
            }
            else {
                s += "0,";
            }
        }
        if (s.charAt(s.length()-1)==',') {
            s = s.substring(0, s.length()-1);
        }

        s += ";";

        for (Pill p : pills) {
            s += p.PillX + "," + p.PillY + ",";
            if (p.taken) {
                s += '1' + ",";
            }
            else {
                s += '0' + ",";
            }
        }

        if (s.charAt(s.length()-1)==',') {
            s = s.substring(0, s.length()-1);
        }

        s += ";";

        for (Pad pad : pads) {
            s += pad.StartX+ "," + pad.StartY + "," + pad.FinishX + "," + pad.FinishY + "," + pad.FinishX + "," + pad.FinishY +"," + pad.StartX + "," + pad.StartY + ",";
        }

        if (s.charAt(s.length()-1)==',') {
            s = s.substring(0, s.length()-1);
        }

        s += ";";

        for (Hostage H : hostages) {
           
            s += H.HostageX + "," + H.HostageY + ",";
            if(H.carried) {
                s += "1,";
            }
            else {
                s += "0,";
            }
            if (H.dropped) {
                s += "1,";
            }
            else {
                s += "0,";
            }
            if(H.alive) {
                s += "1,";
            }
            else {
                s += "0,";
            }
            if (H.mutated) {
                s += "1,";
            }
            else {
                s += "0,";
            }
            if (H.killed) {
                s += "1,";
            }
            else {
                s += "0,";
            }

        }

        if (s.charAt(s.length()-1)==',') {
            s = s.substring(0, s.length()-1);
        }

        /*if (!carriedHostages.isEmpty()) {
            s += ";";

            for (int i=0; i<this.hostages.length; i++) {
                if (this.hostages[i].carried) {
                    s += this.hostages[i].HostageX + "," + this.hostages[i].HostageY + "," + this.hostages[i].damage + ",";
                }
            }

            if (s.charAt(s.length()-1)==',') {
                s = s.substring(0, s.length()-1);
            }

        }*/
        
        return s;
    }

    
}
