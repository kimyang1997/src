/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;
import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class Market {

  String name;

  ArrayList<SolutionOffer> so;
  ArrayList<MarketChannelAssignment> channels;
  ArrayList<String> characteristics;
  ArrayList<Market> submarkets;
  int size;


  
  public Market(String m) {
    name = m;
    characteristics = new ArrayList();
    submarkets = new ArrayList();
    channels = new ArrayList();
  }

  public void addCharacteristics(String c){
    characteristics.add(c);
  }

  public void addChannels(MarketChannelAssignment c){
    channels.add(c);
  }
  
  public String getName() {
		return name;
	}
  

}
