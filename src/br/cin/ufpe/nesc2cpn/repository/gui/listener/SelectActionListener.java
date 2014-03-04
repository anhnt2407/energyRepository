package br.cin.ufpe.nesc2cpn.repository.gui.listener;

import br.cin.ufpe.nesc2cpn.repository.gui.EnergyListJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author avld
 */
public class SelectActionListener implements ActionListener
{
    private EnergyListJFrame frame;

    public SelectActionListener(EnergyListJFrame frame)
    {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent ae)
    {
        frame.setVisible( false );
    }

}
