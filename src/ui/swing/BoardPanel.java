package ui.swing;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Cell;
import service.GameService;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;


public class BoardPanel extends JPanel {

    public final GameService game;

    public BoardPanel(GameService game) {
        this.game = game;
        setLayout(new GridLayout(9, 9, 2, 2));

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                JTextField cell = createCell();
                cell.setBackground(Color.WHITE);
                Cell cellModel = game.getBoard().getCell(r, c);

                if(game.getBoard().getCell(r, c).isFixed()) {
                    String text = String.valueOf(cellModel.getTrueValue());
                    cell.setText(text);
                    cell.setEditable(false);
                }
                cell.putClientProperty("row", r);
                cell.putClientProperty("col", c);
                add(cell);
            }
        }
    }

    private JTextField createCell() {
        JTextField cell = new JTextField();
        cell.setHorizontalAlignment(JTextField.CENTER);
        cell.setFont(new Font("Arial", Font.BOLD, 34));
        setupCellFocus(cell);

        return cell;
    }

    private void refreshBoard() {

    }

    private void setupCellFocus(JTextField cellField) {

        // Instancia o FocusAdapter de forma anônima, direto dentro do parâmetro
        cellField.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) { 
                // Obtém a referência do JTextField que acabou de receber o foco
                JTextField sourceField = (JTextField) e.getSource(); // Ou (JTextField) e.getComponent();

                // Exemplo de ação: destaca a célula selecionada mudando a cor de fundo
                sourceField.setBackground(new Color(230, 240, 255));
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("dentro do lost focus");
                JTextField sourceField = (JTextField) e.getSource();

                Integer value;
                int row = (Integer) sourceField.getClientProperty("row");
                int column = (Integer) sourceField.getClientProperty("col");
                String valor = sourceField.getText();
                if(valor.matches("[1-9]")) {
                    value = Integer.parseInt(valor);
                    game.makeMove(row, column, value);
                    game.printBoard();

                } else if(valor.equals("")) {
                    game.makeMove(row, column, 0);
                    game.printBoard();                    

                } else {
                    sourceField.setText("");
                    game.clearMove(row, column);
                    game.printBoard();
                    JOptionPane.showMessageDialog(null, "Entrada invalida");
                }

                sourceField.setBackground(Color.WHITE);
            }
        });
    }

//    cellField.addKeyListener(new KeyAdapter() {

    /*public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        
        // Se NÃO for um dígito entre '1' e '9' OU se o campo já tiver 1 caractere digitado
        if (c < '1' || c > '9' || cellField.getText().length() >= 1) {
            e.consume(); // Cancela o evento (o caractere não entra no campo)
        }
    }*/
}
