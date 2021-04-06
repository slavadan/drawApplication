package Program.Bars;

import Program.DrawArea;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuBar extends JMenuBar {

    private JMenuItem open, save, newImage;
    private JMenu filemenu;

    private JFileChooser fileChooser;
    private Frame mainFrame;
    private DrawArea drawArea;

    public MenuBar(Frame frame, DrawArea area)
    {
        drawArea = area;
        mainFrame = frame;

        filemenu = new JMenu("File");

        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        newImage = new JMenuItem("New Image");

        filemenu.add(newImage);
        filemenu.add(open);
        filemenu.add(save);


        fileChooser  = new JFileChooser();
        addFileChooserListeners();

        this.add(filemenu);

    }

    private void addFileChooserListeners()
    {
        newImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawArea.clear();
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    drawArea.loadImage(Open());

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Save();
            }
        });
    }

    private Image Open() throws IOException {
        fileChooser.setDialogTitle("Открыть картинку");

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(mainFrame);

        fileChooser.setFileFilter(new FileNameExtensionFilter("*.png", "png"));

        if (result == JFileChooser.APPROVE_OPTION ) {
            BufferedImage bufferedImage = ImageIO.read(fileChooser.getSelectedFile());
            return bufferedImage;
        }
        return null;
    }

    private void Save()
    {
        fileChooser.setDialogTitle("Сохранение файла");

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showSaveDialog(mainFrame);

        fileChooser.setFileFilter(new FileNameExtensionFilter("*.png", "png"));

        if (result == JFileChooser.APPROVE_OPTION ) {
            try {
                ImageIO.write((BufferedImage)drawArea.getImage(), "png", fileChooser.getSelectedFile());
                JOptionPane.showMessageDialog(mainFrame,
                        "Файл '" + fileChooser.getSelectedFile() +
                                " ) сохранен");
            } catch (IOException ioException) {
                System.out.println("Failed to save image!");
            }
        }
    }



}
