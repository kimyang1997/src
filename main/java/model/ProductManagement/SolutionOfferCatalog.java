/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import model.MarketModel.MarketChannelAssignment;

 

/**
 *
 * @author kal bugrara
 */
public class SolutionOfferCatalog {
    ArrayList<SolutionOffer> solutionOffers;

    public SolutionOfferCatalog(){
        solutionOffers= new ArrayList();
        
    }

    //传入价格方法
    public SolutionOffer newSolutionOffer(MarketChannelAssignment mca,int price){
    	SolutionOffer so = new SolutionOffer(mca,price);
        solutionOffers.add(so);
        return so;
    }
    
    
    public SolutionOffer newSolutionOffer(MarketChannelAssignment mca){
    	SolutionOffer so = new SolutionOffer(mca);
        solutionOffers.add(so);
        return so;
    }
    
    public ArrayList<SolutionOffer> getSolutionOffers() {
    	return this.solutionOffers;
    }

     
    
    public ArrayList<SolutionOffer> findSolutionsForMarketChannelCombo(MarketChannelAssignment mca){
        ArrayList<SolutionOffer> foundSolutions = new ArrayList();
        for (SolutionOffer so: solutionOffers){
            if (so.isOfferTargetMarketChannel(mca) == true){
                foundSolutions.add(so);
            }
        }
        return foundSolutions;

    }
}
