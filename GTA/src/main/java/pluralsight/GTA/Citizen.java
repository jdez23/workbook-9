package pluralsight.GTA;

import jakarta.persistence.*;

@Entity
@Table(name = "Citizens", schema = "GTA")
public class Citizen {

    @Id
    @Column(name = "CitizenID")
    private Long citizenId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Alias")
    private Long alias;

    @Column(name = "Age")
    private int age;

    @Column(name = "Profession")
    private String profession;

    @Column(name = "WantedLevel")
    private int wantedLevel;

    // 🛠️ Getters
    public Long getCitizenID() {
        return citizenId;
    }

    public String getName() {
        return name;
    }

    public Long getAlias() {
        return alias;
    }

    public int getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }

    public int getWantedLevel() {
        return wantedLevel;
    }

    // 🧰 Setters
    public void setCitizenID(Long citizenId) {
        this.citizenId = citizenId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlias(Long alias) {
        this.alias = alias;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setWantedLevel(int wantedLevel) {
        this.wantedLevel = wantedLevel;
    } 
}