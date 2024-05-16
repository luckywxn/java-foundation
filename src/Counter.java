import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.NotificationBroadcasterSupport;

public class Counter extends NotificationBroadcasterSupport implements CounterMBean {
    private int count = 0;

    public Counter() {
        super(new MBeanNotificationInfo[]{
                new MBeanNotificationInfo(
                        new String[]{"countChange"},
                        AttributeChangeNotification.class.getName(),
                        "Count attribute has changed.")
        });
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int count) {
        int oldValue = this.count;
        this.count = count;
        sendNotification(new AttributeChangeNotification(this, 1,
                System.currentTimeMillis(), "Count changed", "count",
                "int", oldValue, this.count));
    }

    @Override
    public void increment() {
        setCount(getCount() + 1);
    }

    @Override
    public void decrement() {
        setCount(getCount() - 1);
    }
}
