package Model;

import java.util.ArrayList;

public class HLEG
{
    ArrayList<exerciseVariaton> trhlegPool = new ArrayList<exerciseVariaton>();

    public HLEG(boolean hasweights)
    {
        ArrayList<exerciseVariaton> templegPool = new ArrayList<exerciseVariaton>();
        templegPool.add(new exerciseVariaton("Glute bridge",true));
        templegPool.add(new exerciseVariaton("Elevated glute bridge",true));
        templegPool.add(new exerciseVariaton("Single leg glute bridge",true));
        templegPool.add(new exerciseVariaton("Hip thrust",true));
        templegPool.add(new exerciseVariaton("Single leg elevated glue bridge",true));
        templegPool.add(new exerciseVariaton("Single leg hip thrust",true));

        int size = templegPool.size();
        for(int i = 0;i<size;i++)
        {
            trhlegPool.add(new exerciseVariaton(templegPool.get(i).getName() + " eccentrics"));
            trhlegPool.add(new exerciseVariaton(templegPool.get(i).getName()));
            if(templegPool.get(i).getWeightable() == true && hasweights == true)
            {
                trhlegPool.add(new exerciseVariaton(templegPool.get(i).getName() + " weighted eccentrics"));
                trhlegPool.add(new exerciseVariaton(templegPool.get(i).getName() + " weighted"));
                trhlegPool.add(new exerciseVariaton(templegPool.get(i).getName() + " weighted++ eccentrics"));
                trhlegPool.add(new exerciseVariaton(templegPool.get(i).getName() + " weighted++"));
            }
        }
        size = trhlegPool.size();
        for(int j =0;j<size;j++)
        {
            trhlegPool.get(j).setDifficulty(j+1);
            System.out.println(trhlegPool.get(j).getName());
        }
    }
}
