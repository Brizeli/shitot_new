package com.shitot.model;

import javax.persistence.*;

/**
 * Created by Next on 20.07.2016.
 */
@NamedQueries({
                  @NamedQuery(name = Certificate.ALL_SORTED, query = "select c from certificates c order by c.name"),
})
@Entity(name = "certificates")
public class Certificate extends NamedEntity {

    public static final String ALL_SORTED = "Certificate.getAllSorted";

    @Lob
    private byte[] file;

    public Certificate() {
    }

    public Certificate(String name) {
        super(name);
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
