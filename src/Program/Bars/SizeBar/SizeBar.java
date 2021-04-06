package Program.Bars.SizeBar;

import Program.DrawArea;

import javax.swing.*;

public class SizeBar extends JToolBar {
    private DrawArea drawArea;

    public SizeBar(DrawArea area)
    {
        drawArea = area;

        Box box = Box.createVerticalBox();

        SizeButton button10 = new SizeButton(10, drawArea, "10f");
        SizeButton button20 = new SizeButton(20, drawArea, "20f");
        SizeButton button30 = new SizeButton(30, drawArea, "30f");

        box.add(button10);
        box.add(button20);
        box.add(button30);

        this.add(box);

        this.setRollover(false);
        this.setFloatable(false);
    }
}
