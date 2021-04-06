package Program.tools;

import Program.DrawArea;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Pencil extends Tool {

    public Pencil(DrawArea area)
    {
        _color = Color.BLACK;

        drawArea = area;
        createAdapter();
    }

    @Override
    public void draw() {
        graphics.setColor(_color);
        this.graphics.drawLine(oldX, oldY, currentX, currentY);
    }

    @Override
    protected void createAdapter() {
        this.adapter = new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                updateOldCoords(e.getX(), e.getY());
                updateCurrentCoords(e.getX(), e.getY());

                draw();
                drawArea.repaint();
                updateOldCoords(currentX, currentY);
            }
            @Override
            public void mouseDragged(MouseEvent e)
            {
                updateCurrentCoords(e.getX(), e.getY());

                draw();
                drawArea.repaint();
                updateOldCoords(currentX, currentY);
            }
        };
    }

}
