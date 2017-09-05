package me.voson.vnote.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity(name = "note")
public class Note {
    @Id
    @Column(name = "`Id`",  length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "`Note`",  length = 5000)
    private String note;

    @Column(name = "`shortID`", nullable = false, unique = true)
    private Short shortID;

    @Column(name = "`createtime`", updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Timestamp createtime;

    @Column(name = "updatetime" )
    @org.hibernate.annotations.CreationTimestamp
    private Timestamp updatetime;

    public Note(){}

    public Note(String note, Short shortID){this.note=note;this.shortID=shortID;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Short getShortID() {
        return shortID;
    }

    public void setShortID(Short shortID) {
        this.shortID = shortID;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }
}
