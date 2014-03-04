package br.cin.ufpe.nesc2cpn.repository.gui.listener;

import br.cin.ufpe.nesc2cpn.repository.Line;
import br.cin.ufpe.nesc2cpn.repository.gui.EnergyJDialog;
import br.cin.ufpe.nesc2cpn.repository.gui.EnergyListJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author avld
 */
public class EnergyJDialogActionListener implements ActionListener
{
    private static EnergyJDialog dialog;
    private EnergyListJFrame frame;
    private boolean edit;

    public EnergyJDialogActionListener(EnergyListJFrame frame, boolean edit)
    {
        this.frame = frame;
        this.edit = edit;
    }
    
    public void actionPerformed(ActionEvent ae) {
        if( dialog == null )
        {
            dialog = new EnergyJDialog( frame , true );
        }

        if( edit )
        {
            Line line = frame.getEnergySelect();

            if( line == null )
            {
                JOptionPane.showMessageDialog( frame , "You need select a row." );
                return ;
            }

            dialog.setLine( line );
        }
        else
        {
            dialog.setLine( new Line() );
        }

        dialog.setVisible( true );
        dialog.dispose();
    }
    
}
