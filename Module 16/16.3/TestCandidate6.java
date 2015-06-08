/**
 * arraylist verison
 * 
 * @author Bijan Tajmir
 * 
 */
import java.util.*;
public class TestCandidate6
{
    public static void main(String[] args)
    {
        int sum = 0, counter = 0;
        ArrayList<Candidate3> c = new ArrayList<Candidate3>();
        Candidate3 john = new Candidate3("John Smith", 5000);
        c.add(john);
        Candidate3 mary = new Candidate3("Mary Miller", 4000);
        c.add(mary);
        Candidate3 michael = new Candidate3("Michael Duffy", 6000);
        c.add(michael);
        Candidate3 tim = new Candidate3("Tim Robinson", 2500);
        c.add(tim);
        Candidate3 joe = new Candidate3("Joe Ashtony", 1800);
        c.add(joe);
        Candidate3 mickey = new Candidate3("Mickey Jones", 3000);
        c.add(mickey);
        Candidate3 rebecca = new Candidate3("Rebecca Morgan", 2000);
        c.add(rebecca);
        Candidate3 kathleen = new Candidate3("Kathleen Turner", 8000);
        c.add(kathleen);
        Candidate3 tory = new Candidate3("Tory Parker", 500);
        c.add(tory);
        Candidate3 ashton = new Candidate3("Ashton Davis", 10000);
        c.add(ashton);
        System.out.println("Original Results:");
        for(Candidate3 t : c)
        {
            sum += t.getVotes();
            counter++;
        }
        System.out.println();
        System.out.println("Candidate               Votes Received                      % of Total Votes");
        for(Candidate3 t : c)
        {
            System.out.printf("%15s                %5d                         %2f\n", 
            t.getName(), t.getVotes(), ((double)t.getVotes() / sum) * 100);
        }
        System.out.println();
        System.out.println("Total number of votes in election: " + sum);
        System.out.println();
        System.out.println("Added Mickey Duck, 14000 votes:");
        System.out.println();
        insertPosition(c,5,"Mickey Duck",14000);
        sum = 0;
        for(Candidate3 t : c)
        {
            sum += t.getVotes();
            counter++;
        }
        System.out.println("Candidate               Votes Received                      % of Total Votes");
        for(Candidate3 t : c)
        {
            System.out.printf("%15s                %5d                         %2f\n", 
            t.getName(), t.getVotes(), ((double)t.getVotes() / sum) * 100);
        }
        System.out.println();
        System.out.println("Total number of votes in election: " + sum);
        System.out.println();
        System.out.println("Added Donald Mouse, 100:");
        System.out.println();
        insertCandidate(c,"Kathleen Turner","Donald Mouse",100);
        sum = 0;
        for(Candidate3 t : c)
        {
            sum += t.getVotes();
            counter++;
        }
        System.out.println("Candidate               Votes Received                      % of Total Votes");
        for(Candidate3 t : c)
        {
            System.out.printf("%15s                %5d                         %2f\n", 
            t.getName(), t.getVotes(), ((double)t.getVotes() / sum) * 100);
        }
        System.out.println();
        System.out.println("Total number of votes in election: " + sum);
    }
    public static void insertPosition(List<Candidate3> list, int location, String name, int votes) 
    {          
       // insert item into ArrayList
       list.add(location, new Candidate3(name, votes));
    }
    public static void insertCandidate(List<Candidate3> list, String find, String name, int votes) 
    {
        int location = 0;
        // find location of item you want to insert before
        for(int index = 0; index < list.size(); index++)
        {
          if (list.get(index).getName().equals(find))
          {
               location = index;
          }
        }
        // insert item into ArrayList
        list.add(location, new Candidate3(name, votes));
    }  
}