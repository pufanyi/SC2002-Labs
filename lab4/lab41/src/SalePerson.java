public class SalePerson implements Comparable<SalePerson> {
    private final String firstName;
    private final String lastName;
    private final int totalSales;

    public SalePerson(String first, String last, int sales) {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    public String toString() {
        return lastName + " " + firstName + ": " + totalSales;
    }

    public boolean equals(Object other) {
        if (other instanceof SalePerson otherPerson) {
            return (lastName.equals(otherPerson.lastName) && firstName.equals(otherPerson.firstName) && totalSales == otherPerson.totalSales);
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(SalePerson otherPerson) {
        if (totalSales < otherPerson.totalSales) {
            return -1;
        } else if (totalSales == otherPerson.totalSales) {
            if (lastName.equals(otherPerson.lastName)) {
                return -firstName.compareTo(otherPerson.firstName);
            } else {
                return -lastName.compareTo(otherPerson.lastName);
            }
        } else {
            return 1;
        }
    }
}