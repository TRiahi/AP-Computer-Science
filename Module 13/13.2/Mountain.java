
/**
 * Mountainous terrain.
 * 
 * @author Bijan Tajmir
 * @version 3/1/2015
 */
public class Mountain extends Terrain
{
    private int mountains;
    public Mountain(int l, int w, int m)
    {
        super(l, w);
        mountains = m;
    }
    
    public int getMountains()
    {
        return mountains;
    }
}