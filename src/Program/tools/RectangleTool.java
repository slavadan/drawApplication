package Program.tools;

import Program.DrawArea;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class RectangleTool extends Tool{


    public RectangleTool(DrawArea area)
    {
        drawArea = area;
        _color = Color.BLACK;

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
                shape = new Rectangle();
            }
            @Override
            public void mouseDragged(MouseEvent e)
            {
                int x = Math.min(oldX, e.getX());
                int y = Math.min(oldY, e.getY());
                int width = Math.abs(oldX - e.getX());
                int height = Math.abs(oldY - e.getY());

                if(shape.getClass() == Rectangle.class) {
                    ((Rectangle) shape).setBounds(x, y, width, height);
                }
                drawArea.repaint();
            }
            @Override
            public void mouseReleased(MouseEvent e)
            {
                if(shape.getBounds().width != 0 || shape.getBounds().height != 0)
                {
                    draw();
                }
                shape = null;
            }
    };
}
}
