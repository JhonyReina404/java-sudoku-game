package ui.swing;

import javax.swing.*;

import service.GameService;
import service.Validator;

import java.awt.*;

public class MainWindow extends JFrame{
    
    public MainWindow() {

        Validator validate = new Validator();
        GameService game = new GameService(validate);
        game.startGame();

        setTitle("Sudoku");
        setSize(650, 650);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Centraliza
        BoardPanel boardPanel = new BoardPanel(game);
        add(boardPanel);
        
        ActionPanel actionPanel = new ActionPanel();
        add(actionPanel, BorderLayout.SOUTH);

        actionPanel.setupButtonReset(e -> {
            game.restartGame();
            boardPanel.refreshBoard();
        });

        actionPanel.setupButtonSave(e -> {
            game.startGame();
            boardPanel.refreshBoard();
        });

        actionPanel.setupButtonConclude(e -> {
            if(game.isConclude()){
                JOptionPane.showMessageDialog(null, "Parabens voce completou o jogo!\nVocê pode iniciar um novo jogo ou feche a janela para sair.");
            } else {JOptionPane.showMessageDialog(null, "O jogo não está correto.");}
        });
        
        setVisible(true);
    }
}