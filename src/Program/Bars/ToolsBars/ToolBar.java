package Program.Bars.ToolsBars;

import Program.DrawArea;
import Program.tools.Eraser;
import Program.tools.Line;
import Program.tools.RectangleTool;

import javax.swing.*;

public class ToolBar extends JToolBar {

    private DrawArea drawArea;

    public ToolBar(DrawArea area)
    {
        drawArea = area;

        this.add(new ChangeToolAction(drawArea.getTool(), drawArea, "src/Program/Bars/ToolsBars/images/pencil.png"));
        this.add(new ChangeToolAction(new Line(drawArea), drawArea, "src/Program/Bars/ToolsBars/images/line.png"));
        this.add(new ChangeToolAction(new RectangleTool(drawArea), drawArea, "src/Program/Bars/ToolsBars/images/rectangle.png"));
        this.add(new ChangeToolAction(new Eraser(drawArea), drawArea, "src/Program/Bars/ToolsBars/images/eraser.png"));


        this.setFloatable(false);
        this.setRollover(false);

    }

}
