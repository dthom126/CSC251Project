import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Project_dustin_thomas {
   public static void main(String[] args) throws IOException {
      ArrayList<Policy> policies = new ArrayList<Policy>();

      File file = new File("PolicyInformation.txt");
      Scanner fileScanner = new Scanner(file);

      // Read 8 lines per policy, like Project 2
      while (fileScanner.hasNextLine()) {
         String policyNumber   = fileScanner.nextLine();
         if (policyNumber.trim().equals("")) {
            // Skip empty lines if any
            if (!fileScanner.hasNextLine()) break;
            policyNumber = fileScanner.nextLine();
         }

         if (!fileScanner.hasNextLine()) break;
         String providerName   = fileScanner.nextLine();
         if (!fileScanner.hasNextLine()) break;
         String firstName      = fileScanner.nextLine();
         if (!fileScanner.hasNextLine()) break;
         String lastName       = fileScanner.nextLine();
         if (!fileScanner.hasNextLine()) break;
         int age               = Integer.parseInt(fileScanner.nextLine().trim());
         if (!fileScanner.hasNextLine()) break;
         String smokingStatus  = fileScanner.nextLine();
         if (!fileScanner.hasNextLine()) break;
         double height         = Double.parseDouble(fileScanner.nextLine().trim());
         if (!fileScanner.hasNextLine()) break;
         double weight         = Double.parseDouble(fileScanner.nextLine().trim());

         // Create Policy directly using all data (Policy creates its own PolicyHolder)
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

      // Counters
      int smokers = 0;
      int nonSmokers = 0;

      // Display each Policy by implicitly calling toString()
      for (int i = 0; i < policies.size(); i++) {
         Policy policy = policies.get(i);

         System.out.println(policy);  // implicit toString()
         System.out.println();        // blank line between policies

         // Grab holder to check smoking status
         PolicyHolder holder = policy.getPolicyHolder();
         if ("smoker".equalsIgnoreCase(holder.getSmokingStatus())) {
            smokers++;
         } else {
            nonSmokers++;
         }
      }

      // Summary lines
      System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
      System.out.println();
      System.out.println("The number of policies with a smoker is: " + smokers);
      System.out.println();
      System.out.println("The number of policies with a non-smoker is: " + nonSmokers);
   }
}
