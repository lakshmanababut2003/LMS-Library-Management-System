import util.InputUtil;
import views.EntryView;

public class App {
    public static void main(String[] args) {
        
        EntryView view = new EntryView();
        view.goToLogin();
        InputUtil.getScanner().close();
    }
}
