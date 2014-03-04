package br.cin.ufpe.nesc2cpn.repository.gui.listener;

import br.cin.ufpe.nesc2cpn.repository.Line;
import br.cin.ufpe.nesc2cpn.repository.gui.EnergyJDialog;
import br.cin.ufpe.nesc2cpn.repository.gui.SelectJDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author avld
 */
public class EventAddActionListener implements ActionListener
{
    private EnergyJDialog dialog;
    private SelectJDialog selectDialog;

    public EventAddActionListener(EnergyJDialog dialog)
    {
        this.dialog = dialog;
        selectDialog = new SelectJDialog( dialog , true );
    }

    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            selectDialog.setModel( dialog.getLine().getModuleName() );
            selectDialog.setVisible( true );

            Line line = selectDialog.getLineSelect();

            if( line != null )
            {
                dialog.getListModel().addElement( line.getId() );
            }
        }
        catch(Exception err)
        {
            err.printStackTrace();
            JOptionPane.showMessageDialog( dialog , err.getMessage() );
        }
    }
}
