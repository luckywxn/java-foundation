import java.util.logging.*;

public class LoggingExample {
    private static final Logger logger = Logger.getLogger(LoggingExample.class.getName());

    public static void main(String[] args) {
        // 配置日志级别
        logger.setLevel(Level.FINEST);

        // 创建控制台处理器
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL); // 设置处理器级别为ALL，以捕获所有级别的日志信息
        logger.addHandler(handler);

        // 记录不同级别的日志信息
        logger.finest("This is finest level log."); // 不会被打印，因为默认日志级别高于FINEST
        logger.finer("This is finer level log."); // 同样不会被打印
        logger.fine("This is fine level log."); // 同样不会被打印
        logger.config("This is config level log."); // 可能不会被打印，取决于配置
        logger.info("This is info level log."); // 会被打印
        logger.warning("This is warning level log."); // 会被打印
        logger.severe("This is severe level log."); // 会被打印

        try {
            throw new Exception("A sample exception.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An exception occurred", e); // 打印严重错误及堆栈跟踪
        }
    }
}
