import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener{

    /* JFrame works like the main Windoow where components like lables, buttons ,textfields are added to create a GUI */
    /* Text Area */
    JFrame window;
    JTextArea textArea; //Multi-line area that displays plain text
    JScrollPane scrollPane; //Add Scrollbar when we enter beyound text area
    boolean wordWrapOn = false;

    //  Top Menu Bar

    JMenuBar menuBar; //Add Menu bar of Notepad(File, Edit , Format , Colour etc)
    JMenu menuFile, menuEdit , menuFormat; //Menu icons
    
    //  File Menu 
    JMenuItem iNew , iOpen , iSave , iSaveAs, iExit; //Menu Items 

    //  Format Menu 
    JMenuItem iWrap, iFontArial , iFontCSMS , iFontTNR, iFontBorel , iFontSize8, iFontSize12 , iFontSize16 , iFontSize20 , iFontSize24 , iFontSize28;
    JMenu menuFont , menuFontSize;

    //  Edit Menu 
    JMenuItem iUndo, iRedo;
    
   

    function_File newFile = new function_File(this);
    function_Format newFormat = new function_Format(this);
    function_Edit edit = new function_Edit(this);

    UndoManager um = new UndoManager();
    public static void main(String[] args) {
        new GUI();

    }

    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        creatEditMenu();
        createFormatMenu();

        //Defalut conditions
        newFormat.selectedFont = "Arial"; 
        newFormat.createFont(16);
        newFormat.wordWrap();
        window.setVisible(true);

        window.setVisible(true); //We can see window
    }

    public void createWindow(){
        window = new JFrame("Notepad");   //Initialze the window
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //we need to close frame properly
    }

    public void createTextArea(){
        textArea = new JTextArea();

        textArea = new JTextArea(); 
        textArea.getDocument().addUndoableEditListener( new UndoableEditListener() {

            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
            
        });

        scrollPane = new JScrollPane(textArea , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        window.add(scrollPane);
 
    }

    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        
    }

    public void creatEditMenu() {
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this); //we're implementing Action Listner(use to understand button is clicked) to this GUI class
        iUndo.setActionCommand("Undo"); //set string value to trigger the ActionListener on this item 
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this); //we're implementing Action Listner(use to understand button is clicked) to this GUI class
        iRedo.setActionCommand("Redo"); //set string value to trigger the ActionListener on this item 
        menuEdit.add(iRedo);

    }

    public void createFileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this); //we're implementing Action Listner(use to understand button is clicked) to this GUI class
        iNew.setActionCommand("New"); //set string value to trigger the ActionListener on this item 
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this); 
        iOpen.setActionCommand("Open"); 
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this); 
        iSave.setActionCommand("Save"); 
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this); 
        iSaveAs.setActionCommand("SaveAs"); 
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this); 
        iExit.setActionCommand("Exit"); 
        menuFile.add(iExit);
    }

    public void createFormatMenu() { 
        iWrap = new JMenuItem("Word Wrap: Off"); 
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap"); 
        menuFormat.add(iWrap); 
        // Fonts
        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial"); 
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS"); 
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS); 
       
        iFontTNR = new JMenuItem("Times New Roman"); 
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR); 

        // iFontBorel = new JMenuItem("Borel"); 
        // iFontBorel.addActionListener(this);
        // iFontBorel.setActionCommand("Borel");
        // menuFont.add(iFontBorel);

        
        // Font size
        menuFontSize = new JMenu("Font Size"); 
        menuFormat.add(menuFontSize);
        //iFontSize8, iFontSize12 , iFontSize16 , iFontSize20 , iFontSize24 , iFontSize28;
        iFontSize8 = new JMenuItem("8"); 
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8"); 
        menuFontSize.add(iFontSize8); 

        iFontSize12 = new JMenuItem("12"); 
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12"); 
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16"); 
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16"); 
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20"); 
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20"); 
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24"); 
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24"); 
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28"); 
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size28"); 
        menuFontSize.add(iFontSize28);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();

        switch(command){
            case "New"          : newFile.newFile();
                                    break;
            case "Open"         : newFile.open();
                                    break;
            case "SaveAs"       : newFile.saveAs();
                                    break;
            case "Save"         : newFile.save();
                                    break;
            case "Word Wrap"    : newFormat.wordWrap();
                                    break; 

            case "Exit"         : newFile.exit();
                                    break; 
                                    
             case "Undo"        : edit.undo();
                                    break; 

             case "Redo"        : edit.redo();
                                    break; 

            case "Arial"        : newFormat.setFont(command);
                                    break; 
            case "Comic Sans MS"    : newFormat.setFont(command);
                                    break; 
            case "Times New Roman"    : newFormat.setFont(command);
                                    break;
            
            case "size8"        : newFormat.createFont(8);
                                    break;
            case "size12"        : newFormat.createFont(12);
                                    break;
            case "size16"        : newFormat.createFont(16);
                                    break;
            case "size20"        : newFormat.createFont(20);
                                    break;
            case "size24"        : newFormat.createFont(24);
                                    break;
            case "size28"        : newFormat.createFont(28);
                                    break;
            
        }
    }
}
