import java.util.ArrayList;
import java.util.List;

public class NullPo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add(null);
        list.get(0).length();
    }
}
