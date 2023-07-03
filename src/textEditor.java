import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        menuBar.setBackground(Color.yellow);
        frame.add(textarea);
        frame.setJMenuBar(menuBar);
        file=new JMenu("File");
        edit=new JMenu("Edit");
        save=new JMenuItem("Save File");
        newfile=new JMenuItem("New");
        open =new JMenuItem("Open");
        cut=new JMenuItem("Cut");
        copy=new JMenuItem("Copy");
        paste=new JMenuItem("Paste");
        close=new JMenuItem("Close");
        selectAll=new JMenuItem("Select All");
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

       }
       if(e.getSource()==save){

       }
       if(e.getSource()==open){

       }
    }
}
