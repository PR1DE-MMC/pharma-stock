package tekup.tic1n.moyi.model;

import java.util.Objects;

public class Molecule extends AbstractEntity {
    private String name;

    public Molecule() {
        super(0);
    }

    public Molecule(int id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Molecule molecule)) return false;
        return id == molecule.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Molecule{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
