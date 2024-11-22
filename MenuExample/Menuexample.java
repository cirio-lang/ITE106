import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class MenuExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem closeItem = new JMenuItem("Close");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(closeItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem undoItem = new JMenuItem("Undo");
        JMenuItem redoItem = new JMenuItem("Redo");
        JMenuItem cutItem = new JMenuItem("Cut");

        editMenu.add(undoItem);
        editMenu.add(redoItem);
        editMenu.add(cutItem);

        JMenuBar menubar = new JMenuBar();
        menubar.add(fileMenu);
        menubar.add(editMenu);

        frame.setJMenuBar(menubar);

        MenuActionListener listener = new MenuActionListener(frame);

        newItem.addActionListener(listener);
        openItem.addActionListener(listener);
        closeItem.addActionListener(listener);
        undoItem.addActionListener(listener);
        redoItem.addActionListener(listener);
        cutItem.addActionListener(listener);

        frame.setVisible(true);
    }
}

class MenuActionListener implements ActionListener {
    private JFrame frame;

    public MenuActionListener(JFrame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, 
            "Got an ActionEvent at " + new Date(e.getWhen()) + 
            " from " + e.getSource().getClass().getName());
    }
}
