package Program.tools;

import Program.DrawArea;
import Program.tools.Tool;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

public class Line extends Tool {

    public Line(DrawArea area) {
        _color = Color.BLACK;
        drawArea = area;

        createAdapter();
    }

    @Override
    public void draw() {
        graphics.setColor(_color);
        graphics.draw(shape);

        drawArea.repaint();
    }

    @Override
    protected void createAdapter() {
        this.adapter = new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                updateOldCoords(e.getX(), e.getY());
                shape = new Line2D.Double();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(shape.getBounds().width != 0 || shape.getBounds().height != 0)
                {
                    draw();
                }
                shape = null;
            }

            @Override
            public void mouseDragged(MouseEvent e) {

                if(shape.getClass() == Line2D.Double.class) {
                    ((Line2D) shape).setLine(oldX, oldY, e.getX(), e.getY());
                }
                drawArea.repaint();
            }
        };
    }

}
