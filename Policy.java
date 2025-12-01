/**
 * Policy
 *
 * Models a single insurance policy.
 * Now uses a PolicyHolder object to represent the person.
 */
public class Policy {
   // Policy-specific fields
   private String policyNumber;
   private String providerName;
   private PolicyHolder policyHolder;  // aggregation: Policy "has a" PolicyHolder

   // Static field to track number of Policy objects created
   private static int policyCount = 0;

   /**
    * No-arg constructor.
    */
   public Policy() {
      policyNumber = "";
      providerName = "";
      policyHolder = new PolicyHolder();
      policyCount++;
   }

   /**
    * Full constructor that takes all policy and policyholder data.
    */
   public Policy(String policyNumber, String providerName,
                 String firstName, String lastName,
                 int age, String smokingStatus,
                 double heightInches, double weightPounds) {

      this.policyNumber = policyNumber;
      this.providerName = providerName;

      // Create a PolicyHolder from the holder data
      this.policyHolder = new PolicyHolder(firstName, lastName,
                                           age, smokingStatus,
                                           heightInches, weightPounds);

      policyCount++;
   }

   /**
    * Full constructor that accepts an existing PolicyHolder.
    * Uses a copy to avoid privacy leaks.
    */
   public Policy(String policyNumber, String providerName,
                 PolicyHolder holder) {
      this.policyNumber = policyNumber;
      this.providerName = providerName;
      this.policyHolder = new PolicyHolder(holder); // copy
      policyCount++;
   }

   // Getters
   public String getPolicyNumber()  { return policyNumber; }
   public String getProviderName()  { return providerName; }

   /**
    * Returns a *copy* of the PolicyHolder so outside code
    * cannot directly mutate our internal object.
    */
   public PolicyHolder getPolicyHolder() {
      return new PolicyHolder(policyHolder);
   }

   // Setters
   public void setPolicyNumber(String policyNumber)  { this.policyNumber = policyNumber; }
   public void setProviderName(String providerName)  { this.providerName = providerName; }

   /**
    * Updates the PolicyHolder with a copy of the given object.
    */
   public void setPolicyHolder(PolicyHolder holder) {
      this.policyHolder = new PolicyHolder(holder);
   }

   /**
    * Static method to retrieve number of Policy objects created.
    */
   public static int getPolicyCount() {
      return policyCount;
   }

   /**
    * Calculates the policy price based on the holder's data.
    * Base = 600
    * +75 if age > 50
    * +100 if smoker
    * +(BMI - 35) * 20 if BMI > 35
    */
   public double getPrice() {
      double price = 600.0;
      int age = policyHolder.getAge();
      String smokingStatus = policyHolder.getSmokingStatus();
      double bmi = policyHolder.getBMI();

      if (age > 50) {
         price += 75.0;
      }
      if ("smoker".equalsIgnoreCase(smokingStatus)) {
         price += 100.0;
      }
      if (bmi > 35.0) {
         price += (bmi - 35.0) * 20.0;
      }
      return price;
   }

   /**
    * toString for the Policy.
    * Demo will use System.out.println(policy) to output this.
    */
   public String toString() {
      String result = "";
      result += "Policy Number: " + policyNumber + "\n\n";
      result += "Provider Name: " + providerName + "\n\n";
      // Delegate person details to PolicyHolder's toString
      result += policyHolder.toString() + "\n";
      result += String.format("Policy Price: $%.2f%n", getPrice());
      return result;
   }
}
