package tekup.tic1n.moyi.models;

import java.util.Objects;

public class Stock extends AbstractEntity {
    private Medication medication;
    private int quantity;

    public Stock(int id) {
        super(id);
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity(int i) {
        this.quantity += i;
    }

    public void decreaseQuantity(int i) {
        this.quantity = Math.max(this.quantity - i, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock stock)) return false;
        return Objects.equals(medication, stock.medication);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", medication=" + medication.toString() +
                ", quantity=" + quantity +
                "} ";
    }

    @Override
    public int hashCode() {
        return Objects.hash(medication, quantity);
    }
}
