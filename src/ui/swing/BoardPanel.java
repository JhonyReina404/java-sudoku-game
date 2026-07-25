package ui.swing;

import javax.swing.JPanel;
import javax.swing.JTextField;

import service.GameService;

import java.awt.*;
import java.awt.event.KeyEvent;

public class BoardPanel extends JPanel {

    private final JTextField[][] cellFields = new JTextField[9][9];

    public BoardPanel(GameService game) {
        setLayout(new GridLayout(9, 9, 2, 2));
        game.startGame();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                cell.setFont(new Font("Arial", Font.BOLD, 34));
                if(game.getBoard().getCell(r, c).isFixed()) {
                    String text = String.valueOf(game.getBoard().getCell(r, c).getTrueValue());
                    cell.setText(text);
                    cell.setEditable(false);
                }
                cellFields[r][c] = cell;
                add(cell);
            }
        }
        
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
