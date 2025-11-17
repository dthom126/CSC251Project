import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Project_dustin_thomas {
   public static void main(String[] args) throws IOException {
      
      ArrayList<Policy> policies = new ArrayList<Policy>();

      File file = new File("PolicyInformation.txt");
      Scanner fileScanner = new Scanner(file);

      while (fileScanner.hasNextLine()) {
         String policyNumber   = fileScanner.nextLine();
         String providerName   = fileScanner.nextLine();
         String firstName      = fileScanner.nextLine();
         String lastName       = fileScanner.nextLine();
         int age               = Integer.parseInt(fileScanner.nextLine());
         String smokingStatus  = fileScanner.nextLine();
         double height         = Double.parseDouble(fileScanner.nextLine());
         double weight         = Double.parseDouble(fileScanner.nextLine());

         Policy policy = new Policy(
               policyNumber,
               providerName,
               firstName,
               lastName,
               age,
               smokingStatus,
               height,
               weight
         );

         policies.add(policy);
      }

      fileScanner.close();

      int smokers = 0;
      int nonSmokers = 0;

      for (int i = 0; i < policies.size(); i++) {
         Policy policy = policies.get(i);

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
         System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
         System.out.println();
         System.out.println("Policyholder's Height: " + policy.getHeightInches() + " inches");
         System.out.println();
         System.out.println("Policyholder's Weight: " + policy.getWeightPounds() + " pounds");
         System.out.println();
         System.out.printf("Policyholder's BMI: %.2f%n", policy.getBMI());
         System.out.println();
         System.out.printf("Policy Price: $%.2f%n", policy.getPrice());
         System.out.println();

         if (policy.getSmokingStatus().equalsIgnoreCase("smoker")) {
            smokers++;
         } else {
            nonSmokers++;
         }

         System.out.println();
      }
      
      System.out.println("Number of Policyholders that are smokers: " + smokers);
      System.out.println("Number of Policyholders that are non-smokers: " + nonSmokers);
   }
}
