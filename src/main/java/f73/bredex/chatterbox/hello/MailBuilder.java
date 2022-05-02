package f73.bredex.chatterbox.hello;

public class MailBuilder {
    private String msg;
    private String sender;

    public MailBuilder setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public MailBuilder setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public Mail createMail() {
        return new Mail(msg, sender);
    }
}