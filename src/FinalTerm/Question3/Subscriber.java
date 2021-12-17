package FinalTerm.Question3;

public class Subscriber {
    private final Buffer buffer;

    /**
     * @param buffer 从该缓冲区中接收消息
     */
    public Subscriber(Buffer buffer) {
        this.buffer = buffer;
    }

    /**
     * 获取一条消息
     */
    public void subscribe() {
        int num = buffer.getMessage();
        System.out.println("Subscribe " + num);
    }
}
