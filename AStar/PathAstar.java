package AStar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PathAstar
{

    int[][] matrix;

    PathAstar(int[][] matrix)
    {
        this.matrix = matrix;
    }

    public static Node aStar(Node start, Node target)
    {
        PriorityQueue<Node> closedList = new PriorityQueue<>();
        PriorityQueue<Node> openList = new PriorityQueue<>();
    
        start.f = start.g + start.calculateHeuristic(target);
        openList.add(start);
    
        while(!openList.isEmpty())
        {
            Node n = openList.peek();
            if(n == target)
            {
                return n;
            }
    
            for(Node.Edge edge : n.neighbors)
            {
                Node m = edge.node;
                double totalWeight = n.g + edge.weight;
    
                if(!openList.contains(m) && !closedList.contains(m))
                {
                    m.parent = n;
                    m.g = totalWeight;
                    m.f = m.g + m.calculateHeuristic(target);
                    openList.add(m);
                }
                else
                {
                    if(totalWeight < m.g)
                    {
                        m.parent = n;
                        m.g = totalWeight;
                        m.f = m.g + m.calculateHeuristic(target);
    
                        if(closedList.contains(m))
                        {
                            closedList.remove(m);
                            openList.add(m);
                        }
                    }
                }
            }
    
            openList.remove(n);
            closedList.add(n);
        }
        return null;
    }
    
    public static void printPath(Node target)
    {
        Node n = target;
    
        if(n==null)
            return;
    
        List<Integer> ids = new ArrayList<>();
    
        while(n.parent != null)
        {
            ids.add(n.id);
            n = n.parent;
        }
        ids.add(n.id);
        Collections.reverse(ids);
    
        for(int id : ids)
        {
            System.out.print(id + " ");
        }
        System.out.println("");
    }

    void assignBranches(Node[][] n, int row, int col)
    {
        // for up
        if(row - 1 >= 0 && this.matrix[row - 1][col] == 0 && matrix[row][col] == 0)
        {
            n[row][col].addBranch(1, n[row - 1][col]);
        }

        // for down
        if(row + 1 < n.length && this.matrix[row + 1][col] == 0 && matrix[row][col] == 0)
        {
            n[row][col].addBranch(1, n[row + 1][col]);
        }

        // for left
        if(col - 1 >= 0 && this.matrix[row][col - 1] == 0 && matrix[row][col] == 0)
        {
            n[row][col].addBranch(1, n[row][col - 1]);
        }

        // for right
        if(col + 1 < n[0].length && this.matrix[row][col + 1] == 0 && matrix[row][col] == 0)
        {
            n[row][col].addBranch(1, n[row][col + 1]);
        }
    }
    
    void findPath()
    {
        Node[][] n = new Node[this.matrix.length][this.matrix[0].length];
    
        for(int i = 0; i < n.length; i++)
        {
            for(int j = 0; j < n[0].length; j++)
            {
                n[i][j] = new Node(this.matrix[0].length - j - 1);
                // System.out.println(matrix[0].length - j - 1);
            }
        }

        n[0][0].g = 0;

        for(int i = 0; i < n.length; i++)
        {
            for(int j = 0; j < n[0].length; j++)
            {
                assignBranches(n, i, j);
            }
        }

        Node res = aStar(n[0][0], n[1][2]);
        printPath(res);
    }

    public static void main(String[] args) {
        int a[][] = {{0, 0, 0, 0},
                     {0, 0, 0, 0},
                     {1, 0, 0, 1},
                     {1, 0, 0, 0}};
        PathAstar ob = new PathAstar(a);
        ob.findPath();
    }
}

// 0 - Path        
// 1 - Rack or Obstacle