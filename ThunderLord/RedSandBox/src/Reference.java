public class Reference<T>
{
    private T t;
    public Reference() {}
    public Reference(T t) {set(t);}
    public T get() {return t;}
    public void set(T t) {this.t = t;}
}
