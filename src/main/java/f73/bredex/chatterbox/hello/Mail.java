package f73.bredex.chatterbox.hello;


public class Mail {
    String msg;
    String sender;

    public Mail(String msg, String sender) {
        this.msg = msg;
        this.sender = sender;
    }

    public String getMsg() {
        return msg;
    }

    public String getSender() {
        return sender;
    }
}
