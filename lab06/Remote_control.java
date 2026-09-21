package lab06;

interface switchable {
    void on();
    void off();

    default void toggle() {
        on();
    }
}

class Fan implements switchable {
    public void on() {
        System.out.println("Fan is on");
    }

    public void off() {
        System.out.println("Fan is off");
    }
}

class Light implements switchable {
    public void on() {
        System.out.println("Light is on");
    }

    public void off() {
        System.out.println("Light is off");
    }
}

@FunctionalInterface
interface Permission {
    boolean maySwitchOn(switchable device, int hour);
}

public class Remote_control {
    public static void main(String[] args) {

        switchable[] devices = {
            new Fan(),
            new Light()
        };

        System.out.println("Toggling devices:");
        for (switchable device : devices) {
            device.toggle();
        }

        Permission p1 = new Permission() {
            public boolean maySwitchOn(switchable device, int hour) {
                return hour>=6 && hour<=22;
            }
        };

        System.out.println("\nUsing anonymous class:");

        for (switchable device : devices) {
            if (p1.maySwitchOn(device, 10)) {
                device.on();
            } else {
                System.out.println("Device cannot be switched ON");
            }
        }

        Permission p2 =(device, hour) -> hour >= 8 && hour <= 20;

        System.out.println("\nUsing Lambda:");

        for (switchable device : devices) {
            if (p2.maySwitchOn(device, 23)) {
                device.on();
            } else {
                System.out.println("Device cannot be switched ON at this hour");
            }
        }
    }
}
