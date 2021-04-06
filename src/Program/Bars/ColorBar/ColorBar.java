package Program.Bars.ColorBar;

import Program.DrawArea;

import javax.swing.*;
import java.awt.*;

public class ColorBar extends JToolBar {

    private DrawArea drawArea;

    public ColorBar(DrawArea area)
    {
        drawArea = area;

        Box box = Box.createVerticalBox();

        ColorButton redButton = new ColorButton(drawArea, Color.red);
        box.add(redButton);

        ColorButton greenButton = new ColorButton(drawArea, Color.green);
        box.add(greenButton);

        ColorButton yellowButton = new ColorButton(drawArea, Color.yellow);
        box.add(yellowButton);

        ColorButton orangeButton = new ColorButton(drawArea, Color.orange);
        box.add(orangeButton);

        ColorButton cyanButton = new ColorButton(drawArea, Color.cyan);
        box.add(cyanButton);

        ColorButton blackButton = new ColorButton(drawArea, Color.black);
        box.add(blackButton);

        this.add(box);

        this.setRollover(false);
        this.setFloatable(false);
    }

}
