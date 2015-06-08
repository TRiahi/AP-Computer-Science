
/**
 * Prints the Candidate data.
 * 
 * @author Bijan Tajmir
 * 
 */
import java.util.ArrayList;
public class TestCandidate
{
    public static void main(String[] args){
    int sum = 0, counter = 0;
    
    ArrayList<Candidate> c = new ArrayList<Candidate>();
    Candidate john = new Candidate("John Smith", 5000);
    c.add(john);
    
    Candidate mary = new Candidate("Mary Miller", 4000);
    c.add(mary);
    
    Candidate michael = new Candidate("Michael Duffy", 6000);
    c.add(michael);
    
    Candidate tim = new Candidate("Tim Robinson", 2500);
    c.add(tim);
    
    Candidate joe = new Candidate("Joe Ashtony", 1800);
    c.add(joe);
    
    System.out.println("Results Per Candidate:");
    System.out.println("______________________");
    System.out.println();
    
    for(Candidate t : c){
        System.out.println(t.toString());
        sum += t.getVotes();
        counter++;
    }
    
    System.out.println("Candidate               Votes Received                      % of Total Votes");
        for(Candidate t : c){
      System.out.printf("%15s                %5d                         %2f\n", 
            t.getName(), t.getVotes(), ((double)t.getVotes() / sum) * 100);
    }
}
    
}
