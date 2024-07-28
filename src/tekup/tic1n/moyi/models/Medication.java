package tekup.tic1n.moyi.models;

import tekup.tic1n.moyi.models.enumeration.MedicationForm;
import java.util.Objects;

public class Medication extends AbstractEntity {
    private String name;
    private MedicationForm form;
    private String description;
    private float price;

    public Medication(int id) {
        super(id);
    }

    public Medication() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MedicationForm getForm() {
        return form;
    }

    public void setForm(MedicationForm form) {
        this.form = form;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medication that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", form=" + form +
                ", description='" + description + '\'' +
                ", price=" + price +
                "} ";
    }
}
