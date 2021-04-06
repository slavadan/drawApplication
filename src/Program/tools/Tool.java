package Program.tools;

import Program.DrawArea;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;


public abstract class Tool
{
    public Tool() { }

    protected int currentX, currentY, oldX, oldY;
    protected Graphics2D graphics;
    protected MouseInputAdapter adapter;

    protected Color _color;
    protected boolean isChangebleColor = true;
    protected boolean isChangebleSize = true;

    protected DrawArea drawArea;

    protected Shape shape;

    public abstract void draw();
    protected abstract void createAdapter();

    public void updateCurrentCoords(int newX, int newY) {currentX = newX; currentY = newY;}
    public void updateOldCoords(int newX, int newY) {oldX = newX; oldY = newY;}


    public void setColor(Color color) {
        if(isChangebleColor)
        {
            _color = color;
            graphics.setPaint(_color);
        }
    }


    public void setGraphics(Image img) { graphics = (Graphics2D) img.getGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
    public void setGraphics(Graphics g) { graphics = (Graphics2D)g; }
    public Graphics2D getGraphics() { return graphics; }

    public Shape getShape() { return shape; }
    public Color getColor() { return _color; }

    public void setSize(float size) {
        graphics.setStroke(new BasicStroke(size));
    }

    public MouseInputAdapter getAdapter() { return adapter; }
}
