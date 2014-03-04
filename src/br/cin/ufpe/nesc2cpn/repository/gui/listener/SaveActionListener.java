package br.cin.ufpe.nesc2cpn.repository.gui.listener;

import br.cin.ufpe.nesc2cpn.repository.Line;
import br.cin.ufpe.nesc2cpn.repository.RepositoryControl;
import br.cin.ufpe.nesc2cpn.repository.gui.EnergyJDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author avld
 */
public class SaveActionListener implements ActionListener
{
    private EnergyJDialog dialog;

    public SaveActionListener(EnergyJDialog dialog)
    {
        this.dialog = dialog;
    }

    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            int r = JOptionPane.showConfirmDialog( dialog , "Do you want save ?" );

            if( r != JOptionPane.YES_OPTION )
            {
                JOptionPane.showMessageDialog( dialog , "This action is canceled." );
                return ;
            }

            save();
            JOptionPane.showMessageDialog( dialog , "It was successfully saved." );
        }
        catch( Exception err )
        {
            JOptionPane.showMessageDialog( dialog , "ERROR: " + err.getMessage() );
            err.printStackTrace();
        }
    }

    private void save() throws Exception
    {
        Line line = dialog.getLine();

        if( line.getId() <= 0 )
        {
            RepositoryControl.getInstance().add( line );
        }
        else
        {
            RepositoryControl.getInstance().update( line );
        }
    }

}
