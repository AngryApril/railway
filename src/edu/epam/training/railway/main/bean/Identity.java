package edu.epam.training.railway.main.bean;

/**
 * Created by alexey.valiev on 5/14/19.
 */
import java.util.Objects;
import java.util.UUID;

public abstract class Identity {

    private final String id;

    public Identity() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identity identity = (Identity) o;
        return Objects.equals(id, identity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "";
    }
}
