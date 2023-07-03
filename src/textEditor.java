import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.Buffer;
import java.util.jar.JarFile;

public class textEditor implements ActionListener {
    JFrame frame;
    JMenuBar menuBar;
    JMenu file,edit;
    JMenuItem save,newfile,open;
    JMenuItem cut,copy,paste,close,selectAll;
    JTextArea textarea;
    textEditor(){
        frame=new JFrame();
        menuBar=new JMenuBar();
        textarea=new JTextArea();
        textarea.setBackground(Color.white);
        menuBar.setBackground(Color.black);
        JPanel panel=new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setLayout(new BorderLayout(0,0));
        panel.add(textarea);
        frame.add(panel);
        frame.setJMenuBar(menuBar);
        file=new JMenu("File");
        edit=new JMenu("Edit");
        file.setForeground(Color.white);
        edit.setForeground(Color.white);
        Font font = new Font("Helvetica", Font.BOLD,13);
        save=new JMenuItem("Save File");
        newfile=new JMenuItem("New");
        open =new JMenuItem("Open");
        cut=new JMenuItem("Cut");
        copy=new JMenuItem("Copy");
        paste=new JMenuItem("Paste");
        close=new JMenuItem("Close");
        selectAll=new JMenuItem("Select All");
        file.setFont(font);
        edit.setFont(font);
        newfile.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        close.addActionListener(this);
        selectAll.addActionListener(this);
        file.add(newfile);
        file.add(open);
        file.add(save);
        edit.add(selectAll);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(close);

        menuBar.add(file);
        menuBar.add(edit);
        frame.setBounds(100,100,400,400);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==cut){
           textarea.cut(); //textarea has inbuild functions
       }
       if(e.getSource()==copy){
           textarea.copy();
       }
       if(e.getSource()==paste){
          textarea.paste();
       }
       if(e.getSource()==close){
          System.exit(0);
       }

        if(e.getSource()==selectAll){
           textarea.selectAll();
       }
       if(e.getSource()==newfile){
           textEditor teditor=new textEditor();

       }
        if (e.getSource() == save) {
            JFileChooser file = new JFileChooser("Desktop:");
            int choose = file.showSaveDialog(null);
            if (choose == JFileChooser.APPROVE_OPTION) {
                File filee = file.getSelectedFile();
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filee));
                    textarea.write(bufferedWriter);
                    bufferedWriter.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
           }

       }
       if(e.getSource()==open){
          JFileChooser filechooser=new JFileChooser("Desktop:");
          int chooseoption=filechooser.showOpenDialog(null);
          if(chooseoption==JFileChooser.APPROVE_OPTION){
              File file=filechooser.getSelectedFile();
              String filepath= file.getPath();
              try {
                  FileReader fileReader = new FileReader(filepath);
                  BufferedReader bufferedReader = new BufferedReader(fileReader);
                  String intermediate = "", output = "";
                  while ((intermediate = bufferedReader.readLine()) != null) {
                      output += intermediate + "\n";
                  }
                      bufferedReader.close();


                  textarea.setText(output);
              }
              catch(Exception exception){
                  exception.printStackTrace();
              }
          }
       }
    }
}
