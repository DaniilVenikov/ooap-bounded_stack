import java.util.ArrayList;
import java.util.List;

public class BoundedStack<T> {

    // скрытые поля
    private List<T> list; // основное хранилище стека
    private int maxStackSize; // максимально допустимое количество элементов в стеке
    private int pushStatus;
    private int peekStatus; // статус запроса peek()
    private int popStatus; // статус команды pop()

    // интерфейс класса, реализующий АТД BoundedStack
    public static int POP_NIL = 0;
    public static int POP_OK = 1;
    public static int POP_ERR = 2;
    public static int PEEK_NIL = 0;
    public static int PEEK_OK = 1;
    public static int PEEK_ERR = 2;
    public static int PUSH_NIL = 0;
    public static int PUSH_OK = 1;
    public static int PUSH_ERR = 2;

    public BoundedStack(int maxStackSize) {
        clear();
        this.maxStackSize = maxStackSize;
    }

    public void push(T element) {
        if(list.size() < maxStackSize) {
            list.add(element);
            pushStatus = PUSH_OK;
        } else {
            pushStatus = PUSH_ERR;
        }
    }

    public T peek() {
        T result = null;
        if (list.size() > 0) {
            result = list.get(list.size()-1);
            peekStatus = PEEK_OK;
        } else {
            peekStatus = PEEK_ERR;
        }
        return result;
    }

    public void pop() {
        if (list.size() > 0) {
            list.remove(list.size()-1);
            popStatus = POP_OK;
        } else {
            popStatus = POP_ERR;
        }
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list = new ArrayList<>();

        peekStatus = PEEK_NIL;
        popStatus = POP_NIL;
        pushStatus = PUSH_NIL;
    }

    // запросы статусов
    public int getPopStatus() {
        return popStatus;
    }

    public int getPeekStatus() {
        return peekStatus;
    }

    public int getPushStatus() {
        return pushStatus;
    }
}
