import javax.swing.*;

public class Editor {

    private SmashDeck smashDeck;
    private JButton b;
    private JFileChooser fc = new JFileChooser();
    private JFrame f;
    private JTextArea techArea = new JTextArea();
    private JTextArea repsArea = new JTextArea();
    private JPanel panel;

    public Editor(SmashDeck sd)
    {
        this.smashDeck = sd;
        //create smashPlayer
    }

    private void addSC()
    {
        smashDeck.add(getTechText().getText(), Integer.valueOf(getRepsText().getText()));
        setTechText("");
        setRepsText(0);
    }

    private JTextArea getTechText()
    {
        return techArea;
    }
    private JTextArea getRepsText()
    {
        return repsArea;
    }
    private void setTechText(String s)
    {
        SwingUtilities.invokeLater(() -> techArea.setText(s));
    }
    private void setRepsText(Integer n)
    {
        SwingUtilities.invokeLater(() -> repsArea.setText(n.toString()));
    }


}
