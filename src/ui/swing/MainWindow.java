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
            System.out.println("Reset solicitado");
            game.restartGame();
            boardPanel.refreshBoard();
        });

        actionPanel.setupButtonSave(e -> {
            System.out.println("save solicitado");
        });

        actionPanel.setupButtonConclude(e -> {
            System.out.println("conclude solicitado");
            if(game.isConclude()){
                JOptionPane.showMessageDialog(null, "Parabens voce completou o jogo, uma nova partida irá iniciar automaticamente");
            } else {JOptionPane.showMessageDialog(null, "O jogo não está correto");}
        });

        setVisible(true);

    }


}
/*
package ui;

import model.Board;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final BoardPanel boardPanel;

    public MainWindow(Board board) {
        super("Sudoku Game");

        // Configurações da Janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. Instancia o painel do tabuleiro passando a lógica
        this.boardPanel = new BoardPanel(board);
        add(boardPanel, BorderLayout.CENTER);

        // 2. Cria o painel de botões no rodapé
        JPanel actionPanel = createActionPanel();
        add(actionPanel, BorderLayout.SOUTH);
    }

    private JPanel createActionPanel() {
        JPanel panel = new JPanel(new FlowLayout());

        JButton btnCheck = new JButton("Verificar Solução");
        btnCheck.addActionListener(e -> {
            // Ação ao clicar no botão
            JOptionPane.showMessageDialog(this, "Verificando jogadas...");
        });

        JButton btnRestart = new JButton("Novo Jogo");
        
        panel.add(btnCheck);
        panel.add(btnRestart);

        return panel;
    }
}

*/