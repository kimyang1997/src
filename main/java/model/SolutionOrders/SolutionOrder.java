package model.SolutionOrders;

import model.CustomerManagement.CustomerProfile;
import model.ProductManagement.*;


public class SolutionOrder {

        SolutionOffer selectedSolutionOffer;
        CustomerProfile customerProfile;

        public CustomerProfile getCustomerProfile() {
			return customerProfile;
		}

		public SolutionOrder(SolutionOffer so,CustomerProfile customerProfile){
            selectedSolutionOffer = so;
            this.customerProfile=customerProfile;
        }
        
        public SolutionOrder(SolutionOffer so){
            selectedSolutionOffer = so;
        }

        public int getSolutionPrice(){
            return selectedSolutionOffer.getSolutionPrice();

        }
        
        public int getSolutionMoney() {
        	
        	return selectedSolutionOffer.getSolutionPrice()*selectedSolutionOffer.getQuantity();
        }
    
    
}
