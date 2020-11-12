package spring.boot;

import javax.persistence.*;
import java.util.List;

@Entity
public class Email {
    //region Properties
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "email_id")
    private Integer Id;

    @Version
    private Integer version;

    private String EmailAddress;

    //One way of linking Person to email
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    //endregion

    //region Constructors
    public Email() {}
    public Email(String emailAddress) {
        this.setEmailAddress(emailAddress);
    }
    //endregion

    //region Setters and Getters
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    //endregion

}
