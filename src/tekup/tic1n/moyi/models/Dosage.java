package tekup.tic1n.moyi.models;

public class Dosage extends AbstractEntity {
    private float dosage;
    private String unit;
    private Molecule mol;
    private Medication med;

    public Dosage() {
        super(0);
    }

    public Dosage(int id){
        super(id);
    }

    public float getDosage() {
        return dosage;
    }

    public void setDosage(float dosage) {
        this.dosage = dosage;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Molecule getMol() {
        return mol;
    }

    public void setMol(Molecule mol) {
        this.mol = mol;
    }

    public Medication getMed() {
        return med;
    }

    public void setMed(Medication med) {
        this.med = med;
    }

    @Override
    public String toString() {
        return "Dosage{" +
                "id=" + id +
                ", dosage=" + dosage +
                ", unit='" + unit + '\'' +
                ", mol=" + mol +
                ", med=" + med +
                '}';
    }
}
