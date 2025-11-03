public class Policy {
private String policyNumber;
private String providerName;
private String firstName;
private String lastName;
private String int age;
private String smokingStatus;
private String int heightInInches;
private int weightInPounds;

public Policy() {
policyNumber = "";
providerName = "";
firstName = "";
lastName = "";
age = 0;
smokingStatus = "non-smoker";
heightInInches = 0;
weightInPounds = 0;
}

public Policy(String policyNumber, String providerName,
              String firstName, String lastName,
              int age, String smokingStatus,
              int heightInInches, int weightInPounds) {
this.policyNumber = policyNumber;
this.providerName = providerName;
this.firstName = firstName;
this.lastName = lastName;
this.age = age;
this.smokingStatus = smokingStatus;
this.heightInInches = heightInInches;
this.weightInPounds = weightInPounds;
}

public String getPolicyNumber() { return policyNumber; }
public String getProviderName() { return providerName; }
public String getFirstName() { return firstName; }
public String getLastName() { return lastName; }
public int    getAge() { return age; }
public String getSmokingStatus() { return smokingStatus; }
public int getHeightInInches() { return heightInInches; }
public int getWeightInPounds() { return weightInPounds; }

public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
public void setProviderName(String providerName) { this.providerName = providerName; }
public void setFirstName(String firstName) { this.firstName = firstName; }
public void setLastName(String lastName) { this.lastName = lastName; }
public void setAge(int age) { this.age = age; }
public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }
public void setHeightInInches(int heightInInches) { this.heightInInches = heightInInches; }
public void setWeightInInches(int weightInPounds) { this.weightInPounds = weightInPounds; }
public double getBMI() {
if (heightInInches <= 0 {
return 0.0;
}
return (weightInPounds * 703.0) / (heightInInches * heightInInches);
}

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