package lab12;

import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {

        List<String> logins = Arrays.asList(
                "Krisha", "Diya", "Diya", "Kashvi", "Krisha"
        );

        HashSet<String> uniqueUsers = new HashSet<>(logins);

        LinkedHashSet<String> orderedUsers = new LinkedHashSet<>(logins);

        System.out.println("Unique users: " + uniqueUsers.size());

        System.out.println("First three distinct users:");

        int count = 0;

        for (String user : orderedUsers) {
            System.out.println(user);
            count++;

            if (count == 3)
                break;
        }
    }
}

