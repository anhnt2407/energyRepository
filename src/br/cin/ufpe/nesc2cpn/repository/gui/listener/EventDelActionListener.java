package br.cin.ufpe.nesc2cpn.repository.gui.listener;

import br.cin.ufpe.nesc2cpn.repository.gui.EnergyJDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author avld
 */
public class EventDelActionListener implements ActionListener
{
    private EnergyJDialog dialog;

    public EventDelActionListener(EnergyJDialog dialog)
    {
        this.dialog = dialog;
    }

    public void actionPerformed(ActionEvent ae)
    {
        int row = dialog.getJList().getSelectedIndex();
        if( row == -1 ) return ;

        int r = JOptionPane.showConfirmDialog( dialog , "você deseja excluir essa relação?" );

        if( r == JOptionPane.YES_OPTION )
        {
            dialog.getListModel().remove( row );
        }
    }

}
