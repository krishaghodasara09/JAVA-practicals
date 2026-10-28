package lab11;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class LogAnalyzer {

    public static void main(String[] args) {

        String keyword = "ERROR";

        Path[] files = {
            Paths.get("log1.txt"),
            Paths.get("log2.txt"),
            Paths.get("log3.txt")
        };

        int totalLines = 0;
        int keywordLines = 0;

        try {

            for (Path file : files) {

                long size = Files.size(file);

                System.out.println("\nFile: " + file.getFileName());
                System.out.println("Size: " + size + " bytes");

                List<String> lines = Files.readAllLines(file);

                for (String line : lines) {

                    totalLines++;

                    if (line.contains(keyword)) {
                        keywordLines++;
                    }
                }
            }

            System.out.println("\n----- SUMMARY -----");
            System.out.println("Total lines: " + totalLines);
            System.out.println(
                "Lines containing '" + keyword + "': "
                + keywordLines
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

