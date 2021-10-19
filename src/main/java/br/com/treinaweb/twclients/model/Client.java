package br.com.treinaweb.twclients.model;

import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "date_birth")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateBirth;

    @Column(nullable = false)
    private String profession;

    public Client() {

    }

    public Client(Long id, String name, LocalDate dateBirth, String profession) {
        this.id = id;
        this.name = name;
        this.dateBirth = dateBirth;
        this.profession = profession;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(dateBirth, client.dateBirth) && Objects.equals(profession, client.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateBirth, profession);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateBirth=" + dateBirth +
                ", profession='" + profession + '\'' +
                '}';
    }
}
