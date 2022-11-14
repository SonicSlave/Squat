package Controller;

import Model.*;
import View.*;


public class Start
{
    currentUser mCU = new currentUser();
    UI ui = new UI();
    panelManager nPM = new panelManager(ui);

    public static void main(String args[])
    {
        new Start();
    }

    public Start()
    {
        HLEG nvl = new HLEG(false);

        //ui.T_createUI(mCU);
    }
}

