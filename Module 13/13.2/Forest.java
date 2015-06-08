
/**
 * Forest terrain.
 * 
 * @author Bijan Tajmir
 * @version 3/1/2015
 */
public class Forest extends Terrain
{
    private int trees;
    public Forest(int l, int w, int t)
    {
        super(l, w);
        trees = t;
    }
    
    public int getTrees()
    {
        return trees;
    }
}