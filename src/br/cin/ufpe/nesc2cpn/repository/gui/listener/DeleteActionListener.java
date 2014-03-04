package br.cin.ufpe.nesc2cpn.repository.gui.listener;

import br.cin.ufpe.nesc2cpn.repository.Line;
import br.cin.ufpe.nesc2cpn.repository.RepositoryControl;
import br.cin.ufpe.nesc2cpn.repository.gui.EnergyListJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author avld
 */
public class DeleteActionListener implements ActionListener
{
    private EnergyListJFrame frame;

    public DeleteActionListener(EnergyListJFrame frame)
    {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent ae) {
        try
        {
            int r = JOptionPane.showConfirmDialog( frame , "Do you want save ?" );

            if( r != JOptionPane.YES_OPTION )
            {
                JOptionPane.showMessageDialog( frame , "This action is canceled." );
                return ;
            }

            Line line = frame.getEnergySelect();

            if( line == null )
            {
                JOptionPane.showMessageDialog( frame , "You need select a row." );
                return ;
            }
            
            RepositoryControl.getInstance().delete( line );
            frame.deleteEnergySelect();

            JOptionPane.showMessageDialog( frame , "It was successfully deleted." );
        }
        catch(Exception err)
        {
            JOptionPane.showMessageDialog( frame , "ERROR: " + err.getMessage() );
            err.printStackTrace();
        }
    }
    
}
