package dsai.piano.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonKeys{
    
    public void buildGui(){
        JFrame frame = new JFrame("key buttons");
        JPanel panel = new JPanel(new BorderLayout());
        JButton a = new JButton("A");
        a.addActionListener(evt->{ System.out.println("a pressed");});
        JButton b = new JButton("B");
//        b.addActionListener(evt->{ System.out.println("b pressed");});
        b.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("1");
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("1");
			}
		});
        panel.add(a, BorderLayout.EAST);
        panel.add(b, BorderLayout.WEST);
        
        
        KeyStroke us = KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false);
        panel.getInputMap().put(us, "A");
        panel.getActionMap().put("A", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent evt){
               a.doClick();
               
            }
        });
        
        KeyStroke us2 = KeyStroke.getKeyStroke(KeyEvent.VK_B, 0, false);
        panel.getInputMap().put(us2, "B");
        panel.getActionMap().put("B", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent evt){
               b.doClick();
            }
//            public void keyPre
        });
        a.setFocusable(false);
        b.setFocusable(false);
        
    }

    public static void main(String[] args){
        EventQueue.invokeLater( new ButtonKeys()::buildGui);
//    	new ButtonKeys().buildGui();
    }
}