
/**
 * Class that holds all of the data for the Candidates, and creates the candidate "object". 
 * V2 - now includes Replacing "algorithms".
 * 
 * @author Bijan Tajmir
 * 
 */
public class Candidate2
{
    private String name;
    private int numVotes;

    public Candidate2(String name, int numVotes){
        this.name = name;
        this.numVotes = numVotes;
    }

    public String getName(){
        return name;
    }
    
    public int getVotes(){
        return numVotes;
    }
    
    public String toString(){
        return getName() + " received " + getVotes() + " votes.";
    }
    
    public void replaceName(Candidate2 c){ //switch with a candidate
        System.out.println("Replacing " + name + " with " + c.getName());
        name = c.getName();
    }
    
    public void replaceName(String n){ //overloaded to set your own name to replace
        System.out.println("Replacing " + name + " with " + n);
        name = n;
    }
    
    public void replaceVotes(Candidate2 c){ //switch with a candidate
        System.out.println("Replacing " + name + "'s votes with " + c.getName());
        numVotes = c.getVotes();
    }
    
    public void replaceVotes(int v){ //overloaded, change it to a certain number)
        System.out.println("Replacing " + name + "'s votes with " + v);
        numVotes = v;
    }
}
