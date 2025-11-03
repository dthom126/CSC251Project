import java.util.Scanner;

public class Project_dustin_thomas {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.print("Please enter the Policy Number: ");
String policyNumber = sc.nextLine();
System,out.println();

System.out.print("Please enter the Provider Name: ");
String providerName = sc.nextLine();
System.out.println();

System.out.print("Please enter the Policyholder's First Name: ");
String firstName = sc.nextLine();
System.out.println();

System.out.print("Please enter the Policyholder's Last Name: ");
String lastName = sc.nextLine();
System.out.println();

System.out.print("Please enter the Policyholder's Age: ");
int age = sc.nextInt();
sc.nextLine();
System.out.println();

System.out.print("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
String smokingStatus = sc.nextLine();
System.out.println();

System.out.print("Please enter the Policyholder's Height (in inches): ");
double height = sc.nextDouble();
System.out.println();

System.out.print("Please enter the Policyholder's Weight (in pounds): ");
double weight = sc.nextDouble();
System.out.println();

Policy policy = new Policy(
policyNumber,
providerName,
firstName,
lastName,
age,
smokingStatus,
(int)height,
(int)weight
);

System.out.println("Policy Number: " + policy.getPolicyNumber());
System.out.println();
System.out.println("Provider Name: " + policy.getProviderName());
System.out.println();
System.out.println("Policyholder's First Name: " + policy.getFirstName());
System.out.println();
System.out.println("Policyholder's Last Name: " + policy.getLastName());
System.out.println();
System.out.println("Policyholder's Age: " + policy.getAge());
System.out.println();
System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
System.out.println();
System.out.println("Policyholder's Height: " + height + " inches");
System.out.println();
System.out.println("Policyholder's Weight: " + weight + " pounds");
System.out.println();
System.out.print("Policyholder's BMI: %.2f%n", policy.getBMI());
System.out.println();
System.out.printf("Policy Price: $%.2f%n", policy.getPrice());

sc.close();
}
}