package vmturbo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindCheese {

	interface Place {

        // Return the adjacent Place in the given direction
        public Place goNorth();
        public Place goSouth();
        public Place goEast();
        public Place goWest();
        // Returns true only for the special "Wall" place.
        public boolean isWall();

        // Returns true only for the special "Cheese" place
        public boolean isCheese();

        class Mouse {
        	public Mouse() {}

        	// Return a string of the letters NSEW which, if used to traverse the
        	// the maze from startingPoint, will reach a Place where isCheese() is
        	// true.  Return null if you can't find such a path.
        	public String findCheese(Place startingPoint) {
        		// in case an illegal argument
        		if (startingPoint == null) return null;
        		
        		// a map to store the path reaching to a visited place
        		Map<Place, String> visited = new HashMap<Place, String>();
        		// BFS queue to store places could reach to
        		Queue<Place> queue = new LinkedList<Place>();
        		
        		// initialization
        		queue.offer(startingPoint);
        		visited.put(startingPoint, "");
        		
        		// if cheese is not found
        		while(!queue.isEmpty()) {
        			Place p = queue.poll();
    				if(p.isWall())	continue;
    				// find cheese in this place
    				if(p.isCheese()) return visited.get(p);

    				String path = visited.get(p); 
    				
    				// adjacent places of current place
    				Place to = p.goEast();	
    				if(to != null && !visited.containsKey(to)){
    					visited.put(to, path + "E");
    					queue.offer(to);
    				}
    				
    				to = p.goNorth();
    				if(to != null && !visited.containsKey(to)){
    					visited.put(to, path + "N");
    					queue.offer(to);
    				}

    				to = p.goWest();
    				if(to != null && !visited.containsKey(to)){
    					visited.put(to, path + "W");
    					queue.offer(to);
    				}
    				
    				to = p.goSouth();
    				if(to != null && !visited.containsKey(to)){
    					visited.put(to, path + "S");
    					queue.offer(to);
    				}
        		}
        		return null;	// no cheese found
        	}
        	
        	public String findCheese2(Place startingPoint) {
        		return findCheeseDFS(startingPoint, "", new HashSet<Place>());
        	}
        	
        	/*
        	 * find cheese and return the path to cheese.
        	 * return null if no cheese or no available path to cheese
        	 */
        	public String findCheeseDFS(Place p, String path, Set<Place> visited){
        		if(p == null || p.isWall()) return null;
        		if(p.isCheese()) return path;
        		
        		if(!visited.add(p)) return null;
        		String result = findCheeseDFS(p.goEast(), path + "E", visited);
        		if(result != null) return result;
        		
        		result = findCheeseDFS(p.goSouth(), path + "S", visited);
        		if(result != null) return result;
        		
        		result = findCheeseDFS(p.goWest(), path + "W", visited);
        		if(result != null) return result;
        		
        		result = findCheeseDFS(p.goNorth(), path + "N", visited);
        		if(result != null) return result;
        		return null;
        	}
        }
	}
}
