public class function_Edit {
    
    GUI gui;

    public function_Edit(GUI gui) {
        this.gui = gui;
    }

    public void undo() {
        gui.um.undo();
    }

    public void redo() {
        gui.um.redo();
    }
}
