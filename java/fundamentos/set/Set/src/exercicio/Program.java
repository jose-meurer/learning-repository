package exercicio;

import java.io.*;
import java.sql.SQLOutput;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;

public class Program {

    public static void main(String[] args) {

        File path = new File("in.txt");
        Set<LogEntry> logs = new HashSet<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line = reader.readLine();
            while(line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                LocalDateTime time = LocalDateTime.ofInstant(Instant.parse(fields[1]), ZoneId.systemDefault());

                logs.add(new LogEntry(name, time));

                line = reader.readLine();
            }
            System.out.println("Total users: " + logs.size());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
