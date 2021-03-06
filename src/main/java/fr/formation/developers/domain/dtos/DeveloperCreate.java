package fr.formation.developers.domain.dtos;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class DeveloperCreate {
    @NotNull private String pseudo;
    @NotNull private String firstName;
    @NotNull private String lastName;
    @NotNull private LocalDate birthDate;
    @NotNull private Long mainSkillId;

    public DeveloperCreate() {}

    public String getPseudo() { return pseudo; }
    public void setPseudo(String pseudo) { this.pseudo = pseudo; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getMainSkillId() {
        return mainSkillId;
    }
    public void setMainSkillId(Long mainSkillId) {
        this.mainSkillId = mainSkillId;
    }

    @Override
    public String toString() {
        return "Developer [pseudo=" + pseudo + ", firstName=" + firstName
                + ", lastName=" + lastName + ", birthDate=" + birthDate + ", mainSkillId=" + mainSkillId + "]";
    }
}
