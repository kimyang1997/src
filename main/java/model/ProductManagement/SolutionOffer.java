/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import model.MarketModel.MarketChannelAssignment;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {

  ArrayList<Product> products;
  int price; //floor, ceiling, and target ideas
  int quantity;
  MarketChannelAssignment marketchannelcomb;

  public MarketChannelAssignment getMarketchannelcomb() {
	return marketchannelcomb;
}

public void setMarketchannelcomb(MarketChannelAssignment marketchannelcomb) {
	this.marketchannelcomb = marketchannelcomb;
}

public SolutionOffer(int price,int quantity) {
	  this.price=price;
	  this.quantity=quantity;
	  products = new ArrayList<Product>();
}


public SolutionOffer(int price) {
	  this.price=price;
	  products = new ArrayList<Product>();
}


public SolutionOffer(MarketChannelAssignment m, int price) {
	  this.marketchannelcomb=m;
	  this.price=price;
	  products = new ArrayList<Product>();
  }
  
  public SolutionOffer(MarketChannelAssignment m) {
    marketchannelcomb = m;
    products = new ArrayList<Product>();
  }

  public void addProduct(Product p) {
    products.add(p);
  }

  public void setPrice(int p) {
    price = p;
  }

  public int getSolutionPrice(){
    return price;
  }

  public int getQuantity() {
	return quantity;
  }

  
  // this will allow one to retrieve all offers meet for this market/channel
  public boolean isOfferTargetMarketChannel(MarketChannelAssignment mac){
	  return true;

  }
}
