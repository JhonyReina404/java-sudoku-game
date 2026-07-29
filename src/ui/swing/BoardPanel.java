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
    private final JTextField[][] cellFields = new JTextField[9][9];

    public BoardPanel(GameService game) {
        this.game = game;  
        createField();
        refreshBoard();
    }

    private void createField() {
        setLayout(new GridLayout(9, 9, 2, 2));

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                JTextField cell = createCell();
                cell.setBackground(Color.WHITE);
                cell.putClientProperty("row", r);
                cell.putClientProperty("col", c);
                cellFields[r][c] = cell;
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

    public void refreshBoard() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                Cell cellModel = game.getBoard().getCell(r, c);

                if(cellModel.isFixed()) {
                    String text = String.valueOf(cellModel.getTrueValue());
                    cellFields[r][c].setText(text);
                    cellFields[r][c].setEditable(false);
                } else {
                    cellFields[r][c].setText("");
                }
            }
        }
    }

    private void setupCellFocus(JTextField cellField) {

        cellField.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                JTextField sourceField = (JTextField) e.getSource(); 
                sourceField.setBackground(new Color(230, 240, 255));
            }

            @Override
            public void focusLost(FocusEvent e) {
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
}
