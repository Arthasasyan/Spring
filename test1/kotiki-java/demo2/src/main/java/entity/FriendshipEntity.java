package entity;

import javax.persistence.*;

@Entity
@Table(name = "friendship", schema = "public", catalog = "postgres")
public class FriendshipEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "id_one", nullable = true)
    private Integer idOne;
    @Basic
    @Column(name = "id_two", nullable = true)
    private Integer idTwo;

    public FriendshipEntity() {
    }

    public FriendshipEntity(Integer idOne, Integer idTwo) {
        this.idOne = idOne;
        this.idTwo = idTwo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdOne() {
        return idOne;
    }

    public void setIdOne(Integer idOne) {
        this.idOne = idOne;
    }

    public Integer getIdTwo() {
        return idTwo;
    }

    public void setIdTwo(Integer idTwo) {
        this.idTwo = idTwo;
    }
}
