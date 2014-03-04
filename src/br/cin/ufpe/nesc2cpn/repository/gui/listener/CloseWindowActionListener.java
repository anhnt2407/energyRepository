
package br.cin.ufpe.nesc2cpn.repository.gui.listener;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author avld
 */
public class CloseWindowActionListener implements ActionListener
{
    private Window parent;

    public CloseWindowActionListener(Window parent)
    {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent ae)
    {
        this.parent.setVisible( false );
    }

}
