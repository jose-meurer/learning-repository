package exercicio;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

public class LogEntry {

    private String name;
    private LocalDateTime time;

    public LogEntry(String name, LocalDateTime time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return Objects.equals(getName(), logEntry.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
