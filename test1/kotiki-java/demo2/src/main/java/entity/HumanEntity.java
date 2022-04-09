package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "human", schema = "public", catalog = "postgres")
public class HumanEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 30)
    private String name;
    @Basic
    @Column(name = "date_birthday", nullable = true)
    private Date dateBirthday;
    @OneToMany(mappedBy = "humanEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CatsEntity> catsById;

    public HumanEntity() {
    }

    public HumanEntity(String name, Date dateBirthday) {
        this.name = name;
        this.dateBirthday = dateBirthday;
        this.catsById = new HashSet<>();
    }

    public void addCat(CatsEntity cat) {
        cat.setHumanEntity(this);
        this.catsById.add(cat);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(Date dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public Set<CatsEntity> getCatsById() {
        return catsById;
    }

    public void setCatsById(Set<CatsEntity> catsById) {
        this.catsById = catsById;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name:" + this.name + " , date birthday:" + this.dateBirthday;
    }
}
