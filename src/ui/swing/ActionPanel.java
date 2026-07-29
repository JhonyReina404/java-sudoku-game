package ui.swing;


import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import service.GameService;

public class ActionPanel extends JPanel {
  
    private JButton resetBtn = new JButton();
    private JButton saveBtn = new JButton();
    private JButton concludeBtn = new JButton();
    
    public ActionPanel() {
        resetBtn.setText("Reset Game");
        saveBtn.setText("Save Game");
        concludeBtn.setText("Conclude Game");

        add(resetBtn);
        add(saveBtn);
        add(concludeBtn);
    }

    public void setupButtonReset(ActionListener listener){
        resetBtn.addActionListener(listener);
    }

    public void setupButtonSave(ActionListener listener){
        saveBtn.addActionListener(listener);
    }

    public void setupButtonConclude(ActionListener listener){
        concludeBtn.addActionListener(listener);
    }
}
