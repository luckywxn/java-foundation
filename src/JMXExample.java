import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class JMXExample {
    public static void main(String[] args) throws Exception {
        // 创建MBean实例
        Counter counter = new Counter();

        // 获取MBean服务器
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // 创建ObjectName实例，用于唯一标识MBean
        ObjectName name = new ObjectName("com.example.jmx:type=Counter");

        // 注册MBean
        mbs.registerMBean(counter, name);

        System.out.println("Counter MBean registered. You can now connect with a JMX client.");

        // 阻塞主线程，防止程序退出
        synchronized (JMXExample.class) {
            JMXExample.class.wait();
        }
    }
}
