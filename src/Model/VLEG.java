package Model;

import java.util.ArrayList;

public class VLEG
{
    ArrayList<exerciseVariaton> trvlegPool = new ArrayList<exerciseVariaton>();

    public VLEG(boolean hasweights)
    {
        ArrayList<exerciseVariaton> vlegPool = new ArrayList<exerciseVariaton>();
        vlegPool.add(new exerciseVariaton("Squat",true));
        vlegPool.add(new exerciseVariaton("Split squat",true));
        vlegPool.add(new exerciseVariaton("Bulgarian",true));
        vlegPool.add(new exerciseVariaton("Airborne Lunges",false));
        vlegPool.add(new exerciseVariaton("Assisted one leg squat",false));
        vlegPool.add(new exerciseVariaton("Balance assisted one legged squat",false));
        vlegPool.add(new exerciseVariaton("weighted one legged squat",false));
        vlegPool.add(new exerciseVariaton("Pistol squat",false));

        int size = vlegPool.size();
        for(int i = 0;i<size;i++)
        {
            trvlegPool.add(new exerciseVariaton(vlegPool.get(i).getName() + " eccentrics"));
            trvlegPool.add(new exerciseVariaton(vlegPool.get(i).getName()));
            if(vlegPool.get(i).getWeightable() == true && hasweights == true)
            {
                trvlegPool.add(new exerciseVariaton(vlegPool.get(i).getName() + " weighted eccentrics"));
                trvlegPool.add(new exerciseVariaton(vlegPool.get(i).getName() + " weighted"));
                trvlegPool.add(new exerciseVariaton(vlegPool.get(i).getName() + " weighted++ eccentrics"));
                trvlegPool.add(new exerciseVariaton(vlegPool.get(i).getName() + " weighted++"));
            }
        }
        size = trvlegPool.size();
        for(int j =0;j<size;j++)
        {
            trvlegPool.get(j).setDifficulty(j+1);
            System.out.println(trvlegPool.get(j).getName());
        }
    }
}
