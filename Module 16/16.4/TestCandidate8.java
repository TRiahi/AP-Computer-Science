/**
 * arraylist verison
 * 
 * @author Bijan Tajmir
 * 
 ..
 */
import java.util.*;
public class TestCandidate8
{
    public static void main(String[] args)
    {
        int sum = 0, counter = 0;
        ArrayList<Candidate4> c = new ArrayList<Candidate4>();
        Candidate4 john = new Candidate4("John Smith", 5000);
        c.add(john);
        Candidate4 mary = new Candidate4("Mary Miller", 4000);
        c.add(mary);
        Candidate4 michael = new Candidate4("Michael Duffy", 6000);
        c.add(michael);
        Candidate4 tim = new Candidate4("Tim Robinson", 2500);
        c.add(tim);
        Candidate4 joe = new Candidate4("Joe Ashtony", 1800);
        c.add(joe);
        Candidate4 mickey = new Candidate4("Mickey Jones", 3000);
        c.add(mickey);
        Candidate4 rebecca = new Candidate4("Rebecca Morgan", 2000);
        c.add(rebecca);
        Candidate4 kathleen = new Candidate4("Kathleen Turner", 8000);
        c.add(kathleen);
        Candidate4 tory = new Candidate4("Tory Parker", 500);
        c.add(tory);
        Candidate4 ashton = new Candidate4("Ashton Davis", 10000);
        c.add(ashton);
        System.out.println("Original Results:");
        for(Candidate4 t : c)
        {
            sum += t.getVotes();
            counter++;
        }
        System.out.println();
        System.out.println("Candidate               Votes Received                      % of Total Votes");
        for(Candidate4 t : c)
        {
            System.out.printf("%15s                %5d                         %2f\n", 
            t.getName(), t.getVotes(), ((double)t.getVotes() / sum) * 100);
        }
        System.out.println();
        System.out.println("Total number of votes in election: " + sum);
        System.out.println();
        System.out.println("Deleted location 6:");
        System.out.println();
        deleteByLoc(c, 6);
        sum = 0;
        for(Candidate4 t : c)
        {
            sum += t.getVotes();
            counter++;
        }
        System.out.println("Candidate               Votes Received                      % of Total Votes");
        for(Candidate4 t : c)
        {
            System.out.printf("%15s                %5d                         %2f\n", 
            t.getName(), t.getVotes(), ((double)t.getVotes() / sum) * 100);
        }
        System.out.println();
        System.out.println("Total number of votes in election: " + sum);
        System.out.println();
        System.out.println("Deleted Kathleen Turner:");
        System.out.println();
        deleteByName(c, "Kathleen Turner");
        sum = 0;
        for(Candidate4 t : c)
        {
            sum += t.getVotes();
            counter++;
        }
        System.out.println("Candidate               Votes Received                      % of Total Votes");
        for(Candidate4 t : c)
        {
            System.out.printf("%15s                %5d                         %2f\n", 
            t.getName(), t.getVotes(), ((double)t.getVotes() / sum) * 100);
        }
        System.out.println();
        System.out.println("Total number of votes in election: " + sum);
    }
    public static void insertPosition(List<Candidate4> list, int location, String name, int votes) 
    {          
       // insert item into ArrayList
       list.add(location, new Candidate4(name, votes));
    }
    public static void insertCandidate(List<Candidate4> list, String find, String name, int votes) 
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
        list.add(location, new Candidate4(name, votes));
    }
    public static void deleteByLoc(List<Candidate4> list, int location) 
    {          
       // delete item from ArrayList
       list.remove(location);
    }   
    public static void deleteByName(List<Candidate4> list, String find) 
    {
        int location = 0;
        int index;
        // find location of item you want to delete
        for(index = 0; index < list.size(); index++)
        {
          if (list.get(index).getName().equals(find))
          {
              location = index;
              break;
            }
        }
        // delet  item from ArrayList
        if (index != list.size())
        {
         list.remove(location);
        }
    } 
}
