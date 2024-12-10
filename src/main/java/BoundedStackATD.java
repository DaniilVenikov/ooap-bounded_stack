public abstract class BoundedStackATD<T> {

    // конструктор
    // постусловие: создан новый пустой стек с заданным максимально допустимым количеством элементов в стеке
    public abstract BoundedStack<T> BoundedStackATD(int sizeStack);

    // предусловие: не превышено максимально допустимое количество элементов в стеке
    // постусловие: в стек добавлено новое значение
    public abstract void push(T value);

    // предусловие: стек не пустой;
    // постусловие: из стека удалён верхний элемент
    public abstract T pop();

    // предусловие: стек не пустой
    public abstract T peek();

    public abstract int size();

    // постусловие: из стека удалятся все значения
    public abstract void clear();
}
