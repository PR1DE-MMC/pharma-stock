package tekup.tic1n.moyi.services.impl;

import tekup.tic1n.moyi.models.Medication;
import tekup.tic1n.moyi.models.enumeration.MedicationForm;
import tekup.tic1n.moyi.services.AbstractService;

import static java.util.Objects.isNull;
import static tekup.tic1n.moyi.utils.ConsoleUtil.*;
import static tekup.tic1n.moyi.utils.FileSystemUtil.readObjects;

public class MedicationService extends AbstractService<Medication> {

    private static final String FILE_NAME = "medication_db";

    public MedicationService() {
        super(readObjects(FILE_NAME, Medication.class), FILE_NAME);
    }

    @Override
    public int create() {
        Medication newMedication = new Medication(count()+1);
        float price = 0f;
        String description = "";
        String name = "";
        MedicationForm medicationForm = null;

        System.out.println("**********Adding Medication**********");

        while("".equals(name)){
            name = readLine(">>>Enter Medication Name: \n>>>");
        }

        while("".equals(description)){
            description = readLine(">>>Enter Medication Description: \n>>>");
        }

        while(price <= 0f){
            price = readFloat(">>>Enter Medication Price: \n>>>");
        }

        while(isNull(medicationForm)){
            System.out.println(">>>Enter Medication Form: ");
            writeChoices(MedicationForm.values());
            
            medicationForm = (MedicationForm) readChoice(MedicationForm.values());
        }

        newMedication.setName(name);
        newMedication.setDescription(description);
        newMedication.setPrice(price);
        newMedication.setForm(medicationForm);

        items.add(newMedication);
        System.out.println("=> Added Medication: " + newMedication.toString());
        return newMedication.getId();
    }

}
