package tekup.tic1n.moyi.service.impl;

import tekup.tic1n.moyi.model.Dosage;
import tekup.tic1n.moyi.model.Medication;
import tekup.tic1n.moyi.model.Molecule;
import tekup.tic1n.moyi.service.AbstractService;
import tekup.tic1n.moyi.service.exception.InvalidMedicationException;
import tekup.tic1n.moyi.service.exception.InvalidMoleculeException;
import tekup.tic1n.moyi.service.singleton.MedicationServiceSingleton;
import tekup.tic1n.moyi.service.singleton.MoleculeServiceSingleton;

import static java.util.Objects.isNull;
import static tekup.tic1n.moyi.utils.ConsoleUtil.*;
import static tekup.tic1n.moyi.utils.FileSystemUtil.readObjects;

public class DosageService extends AbstractService<Dosage> {

    private static final String FILE_NAME = "dosage_db";

    private final MedicationService medicationService;

    private final MoleculeService moleculeService;

    public DosageService() {
        super(readObjects(FILE_NAME, Dosage.class), FILE_NAME);
        this.medicationService = MedicationServiceSingleton.getInstance();
        this.moleculeService = MoleculeServiceSingleton.getInstance();
    }


    @Override
    public int create() {
        Dosage newDosage = new Dosage(count() + 1);
        Molecule moleculeToAssign = null;
        Medication medicationToAssign = null;
        float dosage = 0F;
        String unit = "";

        System.out.println("**********Adding Dosage**********");

        while (isNull(moleculeToAssign)) {
            try {
                writeChoices(moleculeService.getAll().toArray());
                int molId = readInt(">>>Enter Molecule ID to assign to dosage: \n>>>");
                moleculeToAssign = moleculeService.getById(molId).orElseThrow(InvalidMoleculeException::new);
            } catch (InvalidMoleculeException e) {
                System.out.println(e.getMessage());
                String createChoice = readLine(">>> Would you like to create a new Molecule? ([Y]es | [N]o)\n>>>)");
                if ("y".equalsIgnoreCase(createChoice)) {
                    int newMolId = moleculeService.create();
                    moleculeToAssign = moleculeService.getById(newMolId).orElseThrow(InvalidMoleculeException::new);
                }
            }
        }

        while (isNull(medicationToAssign)) {
            try {
                int medId = readInt(">>>Enter Medication ID to assign to dosage: \n>>>");
                medicationToAssign = medicationService.getById(medId).orElseThrow(InvalidMedicationException::new);
            } catch (InvalidMedicationException e) {
                System.out.println(e.getMessage());
                String createChoice = readLine(">>> Would you like to create a new Medication? ([Y]es | [N]o)\n>>>)");
                if ("y".equalsIgnoreCase(createChoice)) {
                    int newMedId = medicationService.create();
                    medicationToAssign = medicationService.getById(newMedId).orElseThrow(InvalidMedicationException::new);
                }
            }
        }

        while(dosage <= 0f){
            dosage = readFloat(">>>Enter Molecule Dosage in Medication: \n>>>");
        }

        while("".equals(unit)){
            unit = readLine(">>>Enter Unit of measurement: \n>>>");
        }

        newDosage.setDosage(dosage);
        newDosage.setUnit(unit);
        newDosage.setMed(medicationToAssign);
        newDosage.setMol(moleculeToAssign);
        items.add(newDosage);
        System.out.println("=> Added Dosage: " + newDosage.toString());
        return newDosage.getId();
    }
}
