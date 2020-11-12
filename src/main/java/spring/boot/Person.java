package spring.boot;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    //region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Integer Id;

    @Version
    private Integer version;

    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String SSN;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Email> emailList;
    //endregion

    //region Constructors
    public Person() {}
    public Person(String firstName, String middleName, String lastName) {
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
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

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }
    //endregion
}
