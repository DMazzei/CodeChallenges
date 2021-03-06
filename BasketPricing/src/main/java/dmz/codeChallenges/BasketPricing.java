package dmz.codeChallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Optional;

import dmz.codeChallenges.factory.BasketFactory;
import dmz.codeChallenges.factory.SpecialOfferFactory;
import dmz.codeChallenges.model.Basket;
import dmz.codeChallenges.model.BasketItem;
import dmz.codeChallenges.model.SpecialOffer;

class BasketPricing {
    // Constants
    private final String noOfferAppliedMessage = "(No offers available)";
    private final String newLine = "\n";
    private final String currencySign = "£";

    // Application main function
    void run() {
        BufferedReader br = null;

        try {
            // Listening to System.in - input is buffered for efficient reading
            br = new BufferedReader(new InputStreamReader(System.in));
            this.WriteToConsole("Please enter the list of goods (or 'exit' to leave): \n");

            while (true) {
                this.WriteToConsole("------------------------------------------------------\n");
                this.WriteToConsole("PriceBasket > ");
                String input = br.readLine();
                
                if (input == null || input.isEmpty()) 
                    continue;

                if ("EXIT".equals(input.toUpperCase())) {
                    this.WriteToConsole("Good bye!");
                    System.exit(0);
                }
                
                this.ProcessInput(input);
            }
        } catch (Exception e) {
            this.WriteToConsole("A fatal error occurred. Please contact the system support...");
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    this.WriteToConsole("A fatal error occurred. Please contact the system support...");
                    e.printStackTrace();
                }
            }
        }
    }

    // Process user's input (if not empty or 'exit') every time [enter] is pressed
    private void ProcessInput(String input) {

        // Handling any error related to the basket, items, deals or calculation
        // leaving only outstanding errors to the main class
        try {
            // Instantiate the basket and pre populate the lists of items and deals
            Basket basket = new Basket();
            BasketFactory basketFactory = new BasketFactory(input);
            SpecialOfferFactory dealFactory = new SpecialOfferFactory();
            
            if (basketFactory.getSelectedItems().isEmpty()) {
                this.WriteToConsole("No valid item was selected...\n");
                return;
            }
            
            basket.setItems(basketFactory.getSelectedItems());
            
            CalculateBasket calculateBasket = new CalculateBasket(basket, dealFactory.getSpecialOffers());
            calculateBasket.PerformCalculation();

            DecimalFormat format = new DecimalFormat("0.00");
            StringBuilder sb = new StringBuilder();
            
            sb.append("Subtotal: ");
            sb.append(this.currencySign);
            sb.append(format.format(basket.getSubtotal()));
            sb.append(this.newLine);
            
            if (basket.getDeals().isEmpty()) {
                sb.append(this.noOfferAppliedMessage);
                sb.append(this.newLine);
            } else {
                for (SpecialOffer deal : basket.getDeals()) {
                    Optional<BasketItem> item = basket.getItems()
                                                      .stream()
                                                      .filter(s -> s.getId().equals(deal.getItemTarget()))
                                                      .findAny();
                    if (item.isPresent()) {
                        sb.append(item.get().getName());
                        sb.append(' ');
                        sb.append(deal.getDescription());
                        sb.append(": ");
                        sb.append(this.currencySign);
                        sb.append(format.format(item.get().getValueOff()));
                        sb.append(this.newLine);
                    }
                }
            }
            
            sb.append("Total: ");
            sb.append(this.currencySign);
            sb.append(format.format(basket.getTotal()));
            sb.append(this.newLine);

            // printing result
            this.WriteToConsole(sb.toString());

        } catch (Exception e) {
            this.ErrorHandler(e);
        }
    }

    // Print error message and allow normal flow / user can quit typing 'exit'
    private void ErrorHandler(Exception e) {
        this.WriteToConsole("An error occurred. Message: " + e.getMessage() + "\n");
    }
        
    private void WriteToConsole(String message) {
        if (message != null && !message.isEmpty()) {
            System.out.print(message);
        }
    }
}
