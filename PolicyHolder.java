/**
 * PolicyHolder
 *
 * Represents a person who is covered by an insurance policy.
 * Holds all the data directly related to the person, not the policy itself.
 */
public class PolicyHolder {
   // Fields directly associated with the policyholder
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus; // "smoker" or "non-smoker"
   private double heightInches;
   private double weightPounds;

   /**
    * No-arg constructor – sets simple default values.
    */
   public PolicyHolder() {
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "non-smoker";
      heightInches = 0.0;
      weightPounds = 0.0;
   }

   /**
    * Full constructor – initializes all policyholder fields.
    */
   public PolicyHolder(String firstName, String lastName,
                       int age, String smokingStatus,
                       double heightInches, double weightPounds) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.smokingStatus = smokingStatus;
      this.heightInches = heightInches;
      this.weightPounds = weightPounds;
   }

   /**
    * Copy constructor – used to protect against privacy leaks
    * when we aggregate PolicyHolder inside Policy.
    */
   public PolicyHolder(PolicyHolder other) {
      this.firstName = other.firstName;
      this.lastName = other.lastName;
      this.age = other.age;
      this.smokingStatus = other.smokingStatus;
      this.heightInches = other.heightInches;
      this.weightPounds = other.weightPounds;
   }

   // Getters
   public String getFirstName()      { return firstName; }
   public String getLastName()       { return lastName; }
   public int getAge()               { return age; }
   public String getSmokingStatus()  { return smokingStatus; }
   public double getHeightInches()   { return heightInches; }
   public double getWeightPounds()   { return weightPounds; }

   // Setters
   public void setFirstName(String firstName)        { this.firstName = firstName; }
   public void setLastName(String lastName)          { this.lastName = lastName; }
   public void setAge(int age)                       { this.age = age; }
   public void setSmokingStatus(String smokingStatus){ this.smokingStatus = smokingStatus; }
   public void setHeightInches(double heightInches)  { this.heightInches = heightInches; }
   public void setWeightPounds(double weightPounds)  { this.weightPounds = weightPounds; }

   /**
    * Calculates BMI based on the holder's height and weight.
    */
   public double getBMI() {
      if (heightInches <= 0.0) {
         return 0.0;
      }
      return (weightPounds * 703.0) / (heightInches * heightInches);
   }

   /**
    * Returns a formatted string describing the policyholder.
    * Policy will use this as part of its own toString.
    */
   public String toString() {
      String result = "";
      result += "Policyholder's First Name: " + firstName + "\n\n";
      result += "Policyholder's Last Name: " + lastName + "\n\n";
      result += "Policyholder's Age: " + age + "\n\n";
      result += "Policyholder's Smoking Status (Y/N): " + smokingStatus + "\n\n";
      result += "Policyholder's Height: " + heightInches + " inches\n\n";
      result += "Policyholder's Weight: " + weightPounds + " pounds\n\n";
      result += String.format("Policyholder's BMI: %.2f%n", getBMI());
      return result;
   }
}
