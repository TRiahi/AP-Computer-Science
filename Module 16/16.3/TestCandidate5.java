/**
 * Write a description of class TestCandidate5 here.
 * 
 * @author Bijan Tajmir 
 * 
 */
public class TestCandidate5
{
    public static void main(String[] args)
    {
        int sum = 0;
        int counter = 0;
        Candidate3 john = new Candidate3("John Smith", 5000);
        Candidate3 mary = new Candidate3("Mary Miller", 4000);
        Candidate3 michael = new Candidate3("Michael Duffy", 6000);
        Candidate3 tim = new Candidate3("Tim Robinson", 2500);
        Candidate3 joe = new Candidate3("Joe Ashtony", 1800);
        Candidate3 mickey = new Candidate3("Mickey Jones", 3000);
        Candidate3 rebecca = new Candidate3("Rebecca Morgan", 2000);
        Candidate3 kathleen = new Candidate3("Kathleen Turner", 8000);
        Candidate3 tory = new Candidate3("Tory Parker", 500);
        Candidate3 ashton = new Candidate3("Ashton Davis", 10000);
        Candidate3[] candidates = new Candidate3[] {john, mary, michael, tim, joe, mickey, rebecca, kathleen, tory, ashton};
        //original votes START
        System.out.println("Original Results:");
        System.out.println();
        for(int i = 0; i < candidates.length; i++)
        {
            sum += candidates[i].getVotes();
        }
        System.out.println("Candidate               Votes Received                      % of Total Votes");
        for(int i = 0; i < candidates.length; i++)
        {
            System.out.printf("%15s                %5d                         %2f\n", 
            candidates[i].getName(), candidates[i].getVotes(), ((double)candidates[i].getVotes() / sum) * 100);
        }
        System.out.println();
        System.out.println("Total number of votes in election: " + sum);
        //original votes END
        System.out.println();
        int pos = 5;
        String name = "Mickey Duck";
        int votes = 14000;
        insertPosition(candidates, pos, name, votes);
        sum = 0;
        //new votes START
        System.out.println("Added Mickey Duck, 14000:");
        for(int i = 0; i < candidates.length; i++)
        {
            sum += candidates[i].getVotes();
        }
        System.out.println();
        System.out.println("Candidate               Votes Received                      % of Total Votes");
        for(int i = 0; i < candidates.length; i++)
        {
            System.out.printf("%15s                %5d                         %2f\n", 
            candidates[i].getName(), candidates[i].getVotes(), ((double)candidates[i].getVotes() / sum) * 100);
        }
        System.out.println();
        System.out.println("Total number of votes in election: " + sum);
        //new votes END
        System.out.println();
        name = "Kathleen Turner";
        votes = 100;
        insertCandidate(candidates, name, "Donald Mouse", votes);
        sum = 0;
        //new new votes
        System.out.println("Added Donald Mouse, 100:");
        for(int i = 0; i < candidates.length; i++)
        {
            sum += candidates[i].getVotes();
        }
        System.out.println();
        System.out.println("Candidate               Votes Received                      % of Total Votes");
        for(int i = 0; i < candidates.length; i++)
        {
            System.out.printf("%15s                %5d                         %2f\n", 
            candidates[i].getName(), candidates[i].getVotes(), ((double)candidates[i].getVotes() / sum) * 100);
        }
        System.out.println();
        System.out.println("Total number of votes in election: " + sum);
    }
    public static void insertPosition(Candidate3[] a, int pos, String name, int votes)
    {
        Candidate3[] candidates = a;
        int position = pos;
        String n = name;
        int v = votes;
        for(int i=candidates.length-1;i>position;i--)
        {
            candidates[i] = candidates[i-1];
        }
        Candidate3 newperson = new Candidate3(n, votes);
        candidates[position] = newperson;
    }
    public static void insertCandidate(Candidate3[] a, String name, String newperson, int votes)
    {
        Candidate3[] candidates = a;
        String newb = newperson;
        String n = name;
        int v = votes;
        int pos = 0;
        Candidate3 donald = new Candidate3(newb, votes);
        for(int i=0;i<candidates.length;i++)
        {
            if(candidates[i].getName().equals(n))
            {
                pos = i;
            }
        }
        for(int i=candidates.length-1;i>pos;i--)
        {
            candidates[i] = candidates[i-1];
        }
        candidates[pos]= donald;
    }
}