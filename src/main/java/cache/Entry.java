package cache;

import java.util.Objects;

/**
 * @author Dominik_Janiga
 */
class Entry {

    private final String value;

    Entry(String value) {

        this.value = value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry entry = (Entry) o;
        return Objects.equals(this.value, entry.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.value);
    }

    @Override
    public String toString() {

        return "Entry: " + this.value;
    }
}
