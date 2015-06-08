/**
 * Calculate the trajectory of a projectile based on launch angles and launch velocities.
 * 
 * @author Bijan Tajmir
 * 
 */
class CatapultV2
{
    private int[] speed, angle;
    private double[][] distance;
    public CatapultV2(int[] speed, int [] angle)
    {
        distance = new double [speed.length] [angle.length];
        this.speed = speed;
        this.angle = angle;
    }
    public void calcDistance()
    {
        for (int row = 0; row < distance.length; row++)
        {
            for(int col = 0; col < distance[0].length; col++)
            {
                distance[row][col] = ((int)Math.pow(this.speed[row], 2) * Math.sin(2 * Math.toRadians(this.angle[col]))) / 9.8;
            }
        }
    }
    public void print()
    {
        for (int row = 0; row < distance.length; row++)
        {
            System.out.printf("%7d", this.speed[row]);
            for(int col = 0; col < distance[0].length; col++)
            {
                System.out.printf("%18.2f", distance[row][col]);
            }
            System.out.printf("\n");
        }
    }
}