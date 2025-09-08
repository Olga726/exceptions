package exceptions;
//Разработайте дженерик класс Box, который может хранить объекты любого типа.
// Класс должен иметь методы для установки и получения значения объекта, хранящегося внутри.
public class Box<T> {
    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
