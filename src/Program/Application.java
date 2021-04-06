package Program;


import Program.Bars.ColorBar.ColorBar;
import Program.Bars.MenuBar;
import Program.Bars.SizeBar.SizeBar;
import Program.Bars.ToolsBars.ToolBar;

import javax.swing.*;
import java.awt.*;

public class Application {


    DrawArea drawArea;

    public static void main(String[] args) {
        new Application().launch();
    }

    public void launch() {


        JFrame frame = new JFrame("Swing Paint");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container content = frame.getContentPane();

        content.setLayout(new BorderLayout());

        drawArea = new DrawArea();
        content.add(drawArea, BorderLayout.CENTER);

        ToolBar toolBar = new ToolBar(drawArea);
        content.add(toolBar, BorderLayout.NORTH);

        ColorBar colorBar = new ColorBar(drawArea);
        content.add(colorBar, BorderLayout.WEST);

        SizeBar sizeBar = new SizeBar(drawArea);
        content.add(sizeBar, BorderLayout.EAST);


        frame.setJMenuBar(new MenuBar(frame, drawArea));
        frame.setVisible(true);


    }
}
