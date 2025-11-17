/**
 * Policy
 *
 * Models a single insurance policy for one person.
 *
 */
public class Policy {
   // Fields (attributes)
   /** Policy Number (e.g., "3450"). */
   private String policyNumber;
   /** Provider Name (e.g., "State Farm"). */
   private String providerName;
   /** Policyholder's first name. */
   private String firstName;
   /** Policyholder's last name. */
   private String lastName;
   /** Policyholder's age in years. */
   private int age;
   /** Smoking status string: "smoker" or "non-smoker". */
   private String smokingStatus;
   /** Height in inches (allow decimals to match input like 65.0). */
   private double heightInches;
   /** Weight in pounds (allow decimals to match input like 110.0). */
   private double weightPounds;

   // Constructors 

   /**
    * No-arg constructor. Initializes all fields to simple defaults.
    */
   public Policy() {
      policyNumber = "";
      providerName = "";
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "non-smoker";
      heightInches = 0.0;
      weightPounds = 0.0;
   }

   /**
    * Full constructor that fully initializes a Policy.
    *
    * @param policyNumber   the policy number
    * @param providerName   the provider name
    * @param firstName      the policyholder's first name
    * @param lastName       the policyholder's last name
    * @param age            the policyholder's age (years)
    * @param smokingStatus  "smoker" or "non-smoker"
    * @param heightInches   height in inches
    * @param weightPounds   weight in pounds
    */
   public Policy(String policyNumber, String providerName,
                 String firstName, String lastName,
                 int age, String smokingStatus,
                 double heightInches, double weightPounds) {
      this.policyNumber = policyNumber;
      this.providerName = providerName;
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.smokingStatus = smokingStatus;
      this.heightInches = heightInches;
      this.weightPounds = weightPounds;
   }

   // Accessors (getters)

   /** @return the policy number */
   public String getPolicyNumber() { 
      return policyNumber; }
   /** @return the provider name */
   public String getProviderName() { 
      return providerName; }
   /** @return the policyholder's first name */
   public String getFirstName() { 
      return firstName; }
   /** @return the policyholder's last name */
   public String getLastName() { 
      return lastName; }
   /** @return the policyholder's age */
   public int getAge() { 
      return age; }
   /** @return the smoking status string */
   public String getSmokingStatus() { 
      return smokingStatus; }
   /** @return the height in inches */
   public double getHeightInches() { 
      return heightInches; }
   /** @return the weight in pounds */
   public double getWeightPounds() { 
      return weightPounds; }

   // Mutators (setters)

   /**
    * Sets the policy number.
    * @param policyNumber the new policy number
    */
   public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

   /**
    * Sets the provider name.
    * @param providerName the new provider name
    */
   public void setProviderName(String providerName) { this.providerName = providerName; }

   /**
    * Sets the first name.
    * @param firstName the new first name
    */
   public void setFirstName(String firstName) { this.firstName = firstName; }

   /**
    * Sets the last name.
    * @param lastName the new last name
    */
   public void setLastName(String lastName) { this.lastName = lastName; }

   /**
    * Sets the age.
    * @param age the new age in years
    */
   public void setAge(int age) { this.age = age; }

   /**
    * Sets the smoking status ("smoker" or "non-smoker").
    * @param smokingStatus the new smoking status
    */
   public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

   /**
    * Sets the height in inches.
    * @param heightInches the new height in inches
    */
   public void setHeightInches(double heightInches) { this.heightInches = heightInches; }

   /**
    * Sets the weight in pounds.
    * @param weightPounds the new weight in pounds
    */
   public void setWeightPounds(double weightPounds) { this.weightPounds = weightPounds; }

   // Calculated methods (no stale data)

   /**
    * Computes Body Mass Index (BMI) from current height and weight.
    * Formula: (weight * 703) / (height^2)
    *
    * @return the BMI as a double; returns 0.0 if height is 0 to avoid divide-by-zero
    */
   public double getBMI() {
      if (heightInches <= 0.0) {
         return 0.0;
      }
      return (weightPounds * 703.0) / (heightInches * heightInches);
   }

   /**
    * Computes the policy price based on current age, smoking status, and BMI.
    * Base = $600
    * + $75 if age > 50
    * + $100 if smoker
    * + (BMI - 35) * 20 if BMI > 35
    *
    * @return the calculated policy price
    */
   public double getPrice() {
      double price = 600.0;
   
      if (age > 50) {
         price += 75.0;
      }
      if ("smoker".equalsIgnoreCase(smokingStatus)) {
         price += 100.0;
      }
      double bmi = getBMI();
      if (bmi > 35.0) {
         price += (bmi - 35.0) * 20.0;
      }
      return price;
   }
}
