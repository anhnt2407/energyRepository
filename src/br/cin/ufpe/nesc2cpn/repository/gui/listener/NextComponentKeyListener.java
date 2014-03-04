package br.cin.ufpe.nesc2cpn.repository.gui.listener;

import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NextComponentKeyListener extends KeyAdapter {
    private Window window;
    private boolean crontolPressed;

    public NextComponentKeyListener(){
        this.window = null;
    }

    public NextComponentKeyListener(Window window){
        this.window = window;
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            evt.getComponent().transferFocus();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_CONTROL)
        {
            crontolPressed = true;
        }
        if(evt.getKeyCode() == KeyEvent.VK_TAB)
        {
            evt.getComponent().transferFocus();
        }
        else if(evt.getKeyCode() == 27 && window != null )
        {
            window.setVisible( false );
        }

        keyReleased( evt );
    }

    @Override
    public void keyReleased(KeyEvent evt){
        crontolPressed = false;
    }
}
