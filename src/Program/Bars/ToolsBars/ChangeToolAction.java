package Program.Bars.ToolsBars;

import Program.DrawArea;
import Program.tools.Tool;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ChangeToolAction extends AbstractAction {

    private DrawArea drawArea;
    private Tool tool;

    public ChangeToolAction(Tool nTool, DrawArea area, String filepath)
    {
        tool = nTool;
        drawArea = area;
        putValue(AbstractAction.SMALL_ICON, new ImageIcon(filepath));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        drawArea.changeTool(tool);
    }
}
