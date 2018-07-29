package test.artem.eastwind.event;


import java.util.ArrayList;
import java.util.List;

public class ManagerEvent {
    private List<Event> list = new ArrayList<>();

    public void addEvent(Event...events){
        for (Event event:events){
            list.add(event);
        }
    }
    public void viewListening(String v){
        for (Event event:list)event.view(v);
    }
}
