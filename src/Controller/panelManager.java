package Controller;

import View.UI;

public class panelManager
{
    UI ui;

    public panelManager(UI in)
    {
        ui = in;
    }

    public void drawCP1()
    {
        ui.cP1.setVisible(true);
        ui.cP2.setVisible(false);
        ui.mP.setVisible(false);
    }

    public void drawCP2()
    {
        ui.cP1.setVisible(false);
        ui.cP2.setVisible(true);
        ui.mP.setVisible(false);
    }

    public void drawMainP()
    {
        ui.cP1.setVisible(false);
        ui.cP2.setVisible(false);
        ui.mP.setVisible(true);
    }
}
