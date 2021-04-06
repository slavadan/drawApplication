package Program.Bars.ColorBar;

import Program.DrawArea;
import Program.tools.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButton extends JButton {

    private DrawArea drawArea;
    private ActionListener listener;
    private Color color;

    public ColorButton(DrawArea area, Color nColor)
    {
        drawArea = area;
        color = nColor;

        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawArea.getTool().setColor(color);
            }
        };

        this.addActionListener(listener);

        this.setBackground(color);

    }

}
