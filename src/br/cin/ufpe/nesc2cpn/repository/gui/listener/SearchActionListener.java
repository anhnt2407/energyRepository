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
public class SearchActionListener implements ActionListener
{
    private EnergyListJFrame frame;

    public SearchActionListener(EnergyListJFrame frame)
    {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent ae)
    {
        String moName = frame.getModuleName();
        String inName = frame.getInterfaceName();
        String meName = frame.getMethodName();

        try
        {
            List<Line> list = null;
            list = RepositoryControl.getInstance().list( moName , inName , meName );
            
            frame.setEnergyList( list );
        }
        catch(Exception err)
        {
            JOptionPane.showMessageDialog( frame , "ERROR: " + err.getMessage() );
            err.printStackTrace();
        }
    }

}
