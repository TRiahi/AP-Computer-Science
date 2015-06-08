
/**
 * Prints the Candidate data, and runs the Replacement Methods.
 * 
 * @author Bijan Tajmir
 * 
 */
import java.util.ArrayList;
public class TestCandidate2
{
    public static void main(String[] args){
    int sum = 0, counter = 0;
    
    ArrayList<Candidate2> c = new ArrayList<Candidate2>();
    Candidate2 john = new Candidate2("John Smith", 5000);
    c.add(john);
    
    Candidate2 mary = new Candidate2("Mary Miller", 4000);
    c.add(mary);
    
    Candidate2 michael = new Candidate2("Michael Duffy", 6000);
    c.add(michael);
    
    Candidate2 tim = new Candidate2("Tim Robinson", 2500);
    c.add(tim);
    
    Candidate2 joe = new Candidate2("Joe Ashtony", 1800);
    c.add(joe);
    
    Candidate2 mickey = new Candidate2("Mickey Jones", 3000);
    c.add(mickey);
    
    Candidate2 rebecca = new Candidate2("Rebecca Morgan", 2000);
    c.add(rebecca);
    
    Candidate2 kathleen = new Candidate2("Kathleen Turner", 8000);
    c.add(kathleen);
    
    Candidate2 tory = new Candidate2("Tory Parker", 500);
    c.add(tory);
    
    Candidate2 ashton = new Candidate2("Ashton Davis", 10000);
    c.add(ashton);
    
    System.out.println("Results Per Candidate:");
    System.out.println("______________________");
    System.out.println();
    
    for(Candidate2 t : c){
        System.out.println(t.toString());
        sum += t.getVotes();
        counter++;
    }
    
    System.out.println();
    
    System.out.println("Candidate               Votes Received                      % of Total Votes");
        for(Candidate2 t : c){
      System.out.printf("%15s                %5d                         %2f\n", 
            t.getName(), t.getVotes(), ((double)t.getVotes() / sum) * 100);
    }
    
    
    
    
    michael.replaceName(john);
    mickey.replaceVotes(2500);
    kathleen.replaceName("John Kennedy");
    kathleen.replaceVotes(8500);
    
    System.out.println("\nResults Per Candidate:");
    System.out.println("______________________");
    System.out.println();
    
    for(Candidate2 t : c){
        System.out.println(t.toString());
        sum += t.getVotes();
        counter++;
    }
    
    System.out.println("Candidate               Votes Received                      % of Total Votes");
        for(Candidate2 t : c){
      System.out.printf("%15s                %5d                         %2f\n", 
            t.getName(), t.getVotes(), ((double)t.getVotes() / sum) * 100);
    }
    
    
    
}
    
}
