package Program.Bars.SizeBar;

import Program.DrawArea;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SizeButton extends JButton {

    private float size;
    private DrawArea drawArea;
    private ActionListener listener;

    public SizeButton(float nSize, DrawArea area, String name)
    {
        super(name);
        size = nSize;
        drawArea = area;

        this.listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawArea.getTool().setSize(size);
            }
        };

        this.addActionListener(listener);
    }

}
