package tekup.tic1n.moyi.models;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {
    protected int id;

    protected AbstractEntity() {
        this.id = 0;
    }

    protected AbstractEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
