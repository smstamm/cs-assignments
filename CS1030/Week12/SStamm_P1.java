public class SStamm_P1
{
   public static void main (String[] args)
   {
      // Variables
      double foodTaxRate = 3.0 / 100;
      double nonFoodTaxRate = 6.75 / 100;
      double foodBill = 150;
      double nonFoodBill = 50;
      double foodTaxAmount = 0.0;
      double nonFoodTaxAmount = 0.0;
      double totalTaxAmount = 0.0;
      
      // Calculate tax amount on food bill
      foodTaxAmount = foodBill * foodTaxRate;
      
      // Calculate tax amount on non-food bill
      nonFoodTaxAmount = nonFoodBill * nonFoodTaxRate;
      
      // Add food and non-food tax amounts together
      totalTaxAmount = foodTaxAmount + nonFoodTaxAmount;
      
      // Print total tax amount
      System.out.println("The total tax for your bill is: " + totalTaxAmount);
   }
}