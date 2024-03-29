package Exercise_3;

public abstract class Human implements  Comparable<Human>{
    private String firstName;
    private String lastName;

    public Human() {
    }

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Human o) {
        if (this.getFirstName() != null && o.getFirstName() != null)
        {
            if (this.getFirstName().equals(o.getFirstName()))
            {
                if (this.getLastName() != null && o.getFirstName() != null)
                {
                    return this.getLastName().compareTo(o.getLastName());
                } else if (this.getLastName() != null) {
                    return -1;
                }
                return 1;
            } else
                return this.getFirstName().compareTo(o.getFirstName());
        }  else if (this.getFirstName() != null) {
            return -1;
        }
        return 1;
    }
}
