package Model;

public class exerciseVariaton
{
    String name;
    Boolean weightable;
    int difficulty;

    public exerciseVariaton(String in, Boolean iw)
    {
        name = in;
        weightable = iw;
    }

    public exerciseVariaton(String in)
    {
        name = in;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean getWeightable()
    {
        return this.weightable;
    }

    public void setDifficulty(int i)
    {
        this.difficulty = i;
    }
    public int getDifficulty()
    {
        return this.difficulty;
    }

}
