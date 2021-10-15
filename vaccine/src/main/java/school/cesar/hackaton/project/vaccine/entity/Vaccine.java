package school.cesar.hackaton.project.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(schema = "vaccine_schema", name = "vaccine", uniqueConstraints = { @UniqueConstraint(name = "UNIQUE_NAME", columnNames = { "name" }) })
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "dose_quantity", nullable = false)
    private Integer doseQuantity;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getDoseQuantity() {
        return this.doseQuantity;
    }

    public void setDoseQuantity(final Integer doseQuantity) {
        this.doseQuantity = doseQuantity;
    }

}
