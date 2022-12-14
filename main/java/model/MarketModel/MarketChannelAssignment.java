/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import model.SolutionOrders.SolutionOrder;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {
    


	Market market;
    Channel channel;
    int adBudget;
    int targetRevenue;
    ArrayList<SolutionOrder> orders; //Actual revenues

    public ArrayList<SolutionOrder> getOrders() {
		return orders;
	}



	public Market getMarket() {
		return market;
	}

	 

	public Channel getChannel() {
		return channel;
	}

	 
 
	
    public MarketChannelAssignment(Market m, Channel c,ArrayList<SolutionOrder>  solutionOrders){
        
        market = m;
        channel = c;
        this.orders=solutionOrders;
        
    }
    
    
	
    public MarketChannelAssignment(Market m, Channel c){
        
        market = m;
        channel = c;
        
    }

    public boolean matches(Market m, Channel c){
        if (market == m && channel == c) return true;
        else return false;
    }
    
}
