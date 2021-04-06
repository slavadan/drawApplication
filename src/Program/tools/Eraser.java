package Program.tools;

import Program.DrawArea;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Eraser extends Tool{

    private BasicStroke width;

    public Eraser(DrawArea area)
    {
        drawArea = area;
        _color = Color.WHITE;
        createAdapter();
        isChangebleColor = false;
    }

    @Override
    public void draw() {
        width = (BasicStroke) graphics.getStroke();

        this.graphics.fillOval(currentX,currentY, (int)width.getLineWidth(), (int)width.getLineWidth());
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
