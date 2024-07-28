package tekup.tic1n.moyi.services.impl;

import tekup.tic1n.moyi.models.Molecule;
import tekup.tic1n.moyi.services.AbstractService;

import static tekup.tic1n.moyi.utils.ConsoleUtil.readLine;
import static tekup.tic1n.moyi.utils.FileSystemUtil.readObjects;

public class MoleculeService extends AbstractService<Molecule> {

    private static final String FILE_NAME = "molecule_db";

    public MoleculeService() {
        super(readObjects(FILE_NAME, Molecule.class), FILE_NAME);
    }

    @Override
    public int create() {
        Molecule newMolecule = new Molecule(count() + 1);
        String name = "";

        while("".equals(name)){
            name = readLine(">>>Enter Molecule Name: \n>>>");
        }

        newMolecule.setName(name);
        items.add(newMolecule);
        System.out.println("=> Added Molecule: " + newMolecule.toString());
        return newMolecule.getId();
    }

}
