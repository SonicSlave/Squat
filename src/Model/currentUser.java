package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class currentUser
{
    String name;
    Program currentProgram;

    Boolean hasWeights = false;

    int day;
    int month;
    int year;

    public currentUser()
    {
        SimpleDateFormat nsdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = nsdf.format(new Date());
        String dateSplit[] = date.split("-");
        day = Integer.parseInt(dateSplit[0]);
        month = Integer.parseInt(dateSplit[1]);
        year = Integer.parseInt(dateSplit[2]);
    }

    public void setName(String in)
    {
        this.name = in;
    }
    public String getName()
    {
        return this.name;
    }

    public void setProgram(Program in)
    {
        this.currentProgram = in;
    }

    public Program getProgram()
    {
        return this.currentProgram;
    }

    public int getYear()
    {
        return this.year;
    }
    public int getDay()
    {
        return this.day;
    }

    public int getMonth()
    {
        return this.month;
    }

    public void setHasWeights(Boolean i)
    {
        hasWeights = i;
    }

}
