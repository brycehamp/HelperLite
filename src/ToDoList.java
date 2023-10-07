import java.util.ArrayList;

public class ToDoList {
    // ArrayList to be used to store the ToDo List items 
    private ArrayList<String> ToDo = new ArrayList<String>(); 

    // Adds an item to the list
    public void addItem(String s) {
        ToDo.add(s);
    }

    // Removes an item from the list
    public void removeItem(String s) {
        if (ToDo.contains(s)) {
            ToDo.remove(s);
        }
    }

    // Displays list
    public ArrayList<String> getList() {
        return ToDo;
    }
}
