package Program;

import Program.tools.Eraser;
import Program.tools.Pencil;
import Program.tools.Tool;
import Program.tools.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;



public class DrawArea extends JComponent {

    private final static int AREA_SIZE_X = 1280;
    private final static int AREA_SIZE_Y = 720;
    private BufferedImage image;
    private Tool tool;

    public DrawArea() {
        tool = new Pencil(this);

        // this.setCursor(cursor);

        this.setToolListeners();
    }


    protected void paintComponent(Graphics g) {
        if (image != null) {
            g.drawImage(image, 0, 0, null);
        } else {
            image = new BufferedImage(AREA_SIZE_X, AREA_SIZE_Y, BufferedImage.TYPE_INT_ARGB);

            tool.setGraphics(image);
            tool.setColor(Color.black);

            clear();
        }

        if (tool.getShape() != null) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.draw(tool.getShape());
        }
    }

    public void changeTool(Tool nTool) {
        MouseListener[] listeners = this.getMouseListeners();
        MouseMotionListener[] motionListeners = this.getMouseMotionListeners();

        for (int i = 0; i < motionListeners.length && i < listeners.length; ++i) {
            removeMouseMotionListener(motionListeners[i]);
            removeMouseListener(listeners[i]);
        }

        Color temp = null;
        if (tool.getClass() != Eraser.class) {
            temp = tool.getColor();
        }

        tool = nTool;
        tool.setGraphics(image.getGraphics());

        if (temp != null) {
            tool.setColor(temp);
        }

        setToolListeners();
    }

    protected void setToolListeners() {
        this.addMouseListener(tool.getAdapter());
        this.addMouseMotionListener(tool.getAdapter());
    }

    public void clear() {
        Graphics2D tempGraphics = (Graphics2D) image.getGraphics();
        tempGraphics.setPaint(Color.white);
        tempGraphics.fillRect(0, 0, getSize().width, getSize().height);

        repaint();
    }

    public void loadImage(Image img) {
        clear();
        image = (BufferedImage) img;
        repaint();
    }

    public BufferedImage getImage() { return image; }
    public Tool getTool() { return tool; }
}
