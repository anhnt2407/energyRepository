package br.cin.ufpe.nesc2cpn.repository.gui.listener;

import br.cin.ufpe.nesc2cpn.repository.Line;
import br.cin.ufpe.nesc2cpn.repository.RepositoryControl;
import br.cin.ufpe.nesc2cpn.repository.gui.EnergyListJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author avld
 */
public class ShowAllActionListener implements ActionListener
{
    private EnergyListJFrame frame;

    public ShowAllActionListener(EnergyListJFrame frame)
    {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent ae) {
        try
        {
            List<Line> list = null;
            list = RepositoryControl.getInstance().list();

            frame.setEnergyList( list );
        }
        catch(Exception err)
        {
            JOptionPane.showMessageDialog( frame , "ERROR: " + err.getMessage() );
            err.printStackTrace();
        }
    }

}
