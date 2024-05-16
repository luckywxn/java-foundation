public interface CounterMBean {
    int getCount();
    void setCount(int count);
    void increment();
    void decrement();
}
