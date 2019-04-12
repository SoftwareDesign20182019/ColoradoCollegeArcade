package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NameCommand implements Command {
    private int row;
    private int col;
    private int cursor;
    private String[][] alphabet;

    @FXML
    private Label label;


    //TODO PASS IN THE INSTANCE OF THE TEXT BOX FOR THIS COMMAND INSTEAD OF THE INT
    public NameCommand(int row, int col, Label label) {
        this.row = row;
        this.col = col;
        this.label = label;
//        this.text1 = text1;
        alphabet = new String[3][10];
        alphabet[0][0] = "A";
        alphabet[0][1] = "B";
        alphabet[0][2] = "C";
        alphabet[0][3] = "D";
        alphabet[0][4] = "E";
        alphabet[0][5] = "F";
        alphabet[0][6] = "G";
        alphabet[0][7] = "H";
        alphabet[0][8] = "I";
        alphabet[0][9] = "J";

        alphabet[1][0] = "K";
        alphabet[1][1] = "L";
        alphabet[1][2] = "M";
        alphabet[1][3] = "N";
        alphabet[1][4] = "O";
        alphabet[1][5] = "P";
        alphabet[1][6] = "Q";
        alphabet[1][7] = "R";
        alphabet[1][8] = "S";
        alphabet[1][9] = "T";

        alphabet[2][0] = "U";
        alphabet[2][1] = "V";
        alphabet[2][2] = "W";
        alphabet[2][3] = "X";
        alphabet[2][4] = "Y";
        alphabet[2][5] = "Z";
        alphabet[2][6] = ".";
        alphabet[2][7] = "-";
        alphabet[2][8] = " ";
        alphabet[2][9] = "*";

    }

    @Override
    public String execute() {

//        text1.setTextContent(alphabet[row][col]);
        label.setText(alphabet[row][col]);
        System.out.println(alphabet[row][col]);
        return alphabet[row][col];
    }


    @Override
    public void undo() {
        label.setText(alphabet[2][8]);
    }
}
