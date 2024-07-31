public class Person {
	
    public static void main(String[] args) {

    }
        String firstName;
        String lastName;

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFullName () {
            return this.firstName + this.lastName;
        }
}
