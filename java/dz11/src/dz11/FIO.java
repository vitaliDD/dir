

package dz11;

/**
 *
 * @author ya
 */
public class FIO {
    private String name;
    private String surname;
    private String fatherName;

    public FIO(String name, String surname, String fatherName) {
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "FIO{" + "name=" + name + ", surname=" + surname + ", fatherName=" + fatherName + '}';
    }
    
}
