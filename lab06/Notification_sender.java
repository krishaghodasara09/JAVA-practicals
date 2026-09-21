package lab06;

@FunctionalInterface
interface Notifier {
    void send(String message);
}

interface urgent {
}

class email implements urgent {
    void send(String message) {
        System.out.println("Urgent email: " + message);
    }
}

public class Notification_sender {
    public static void main(String[] args) {

        Notifier email = message ->
            System.out.println("Email: " + message);

        Notifier sms = message ->
            System.out.println("SMS: " + message);

        Notifier[] notifiers = {email, sms};

        String message = "Meeting at 10 am";

        for (Notifier n : notifiers) {
            n.send(message);
        }
    }
}
