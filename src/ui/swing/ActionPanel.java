package ui.swing;


import javax.swing.JButton;
import javax.swing.JPanel;

import service.GameService;

public class ActionPanel extends JPanel {

    public final GameService game;    
    JButton resetBtn = new JButton();
    JButton saveBtn = new JButton();
    JButton concludeBtn = new JButton();
    
    public ActionPanel(GameService game) {
        this.game = game;
        resetBtn.setText("Reset Game");
        saveBtn.setText("Save Game");
        concludeBtn.setText("Conclude Game");

        add(resetBtn);
        add(saveBtn);
        add(concludeBtn);

        resetBtn.addActionListener(e -> setupButtonReset());
        saveBtn.addActionListener(e -> setupButtonSave());
        concludeBtn.addActionListener(e -> setupButtonConclude());
    }

    private void setupButtonReset(){
        System.out.println("Reset clicado");
        game.restartGame();
    }

    private void setupButtonSave(){
        System.out.println("Save clicado");
    }

    private void setupButtonConclude(){
        System.out.println("Conclude clicado");
    }
}
