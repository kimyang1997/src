/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.Personnel.Person;
import model.ProductManagement.SolutionOffer;
import model.ProductManagement.SolutionOfferCatalog;
import model.SolutionOrders.SolutionOrder;

/**
 *
 * @author kal bugrara
 */
public class DigitalMarketingApplication {


 //create MarketChannelAssignment ArrayList
 public static List<MarketChannelAssignment> generateMarketChannelAssignment() {

	  List<Market> marketList=new ArrayList<Market>();
	  List<Channel> channelList=new ArrayList<Channel>();
	  List<MarketChannelAssignment> marketChannelAssignmentList=new ArrayList<MarketChannelAssignment>();
	  Market m1= new  Market("M1");
	  Market m2= new  Market("M2");			  
	  Market m3= new  Market("M3");	
	  Channel c1=new  Channel("C1");
	  Channel c2=new  Channel("C2");
	  Channel c3=new  Channel("C3");  
	  
	  Person p1=new Person("rose","Female");
	  Person p2=new Person("mike","Male");
	  Person p3=new Person("tom","Male");
	  Person p4=new Person("sara","Female");
	  
	  ArrayList<Person> personList=new  ArrayList<Person>();
	  personList.add(p1);
	  personList.add(p2);
	  personList.add(p3);  
	  personList.add(p4);	  
	  
	  marketList.add(m1);
	  marketList.add(m2);
	  marketList.add(m3);
	  	  
	  channelList.add(c1);
	  channelList.add(c2);
	  channelList.add(c3);
	  
	  for(Market marketlobj:marketList) {
		  for(Channel channelobj:channelList) {
	           //10-15 random number
			   int price= 10+(int)(Math.random()*(15-10+1));
	           //1-5 random number
			   int quantity= 1+(int)(Math.random()*(5-1+1));
			  SolutionOffer solutionOffer=new SolutionOffer(price,quantity);
			 
			  //pick customers
			  int index=(int)(Math.random()*4);
			  CustomerProfile customerProfile=new CustomerProfile(personList.get(index));
			  SolutionOrder  solutionOrder=new SolutionOrder(solutionOffer,customerProfile);
			  ArrayList<SolutionOrder> solutionOrderList=new  ArrayList<SolutionOrder>();

			  solutionOrderList.add(solutionOrder);
			  MarketChannelAssignment ma=new MarketChannelAssignment(marketlobj,channelobj,solutionOrderList);
			  marketChannelAssignmentList.add(ma);
		  } 
	  }
	  return marketChannelAssignmentList;
 }
 
  //Q1
  public static void Q1(List<MarketChannelAssignment> marketChannelAssignmentList) {
	 
	  System.out.println("************************Q1********************\nMarket\tChannel\tprice");
	  for(MarketChannelAssignment ma:marketChannelAssignmentList) {
		  String MarketId=ma.getMarket().getName();
		  String ChannelId=ma.getChannel().getChannelType();
		  int price=ma.getOrders().get(0).getSolutionPrice();
		  String msg=String.format("%s\t%s\t%d", 
				  MarketId,
				  ChannelId,
				  price
				  );
		  System.out.println(msg);
	  }	  
  }
  
 //Q3
  public static void Q2(List<MarketChannelAssignment> marketChannelAssignmentList) {
	  System.out.println("************************Q3********************\nCustom\tSex\tMarket\tChannel\tprice");
	  for(MarketChannelAssignment ma:marketChannelAssignmentList) {
		  String cid=ma.getOrders().get(0).getCustomerProfile().getCustomerId();
		  String sex=ma.getOrders().get(0).getCustomerProfile().getPerson().getSex();
		  String MarketId=ma.getMarket().getName();
		  String ChannelId=ma.getChannel().getChannelType();
		  int price=ma.getOrders().get(0).getSolutionPrice();
		  String msg=String.format("%s\t%s\t%s\t%s\t%d", 
				  cid,
				  sex,
				  MarketId,
				  ChannelId,
				  price
				  );
		  System.out.println(msg);
	  }
  }
  
  
  //Q4
  public static void Q3(List<MarketChannelAssignment> marketChannelAssignmentList) {
	  System.out.println("************************Q2********************\nCustom\tMarket\tChannel\tprice");
	  for(MarketChannelAssignment ma:marketChannelAssignmentList) {
		  String cid=ma.getOrders().get(0).getCustomerProfile().getCustomerId();
		  String MarketId=ma.getMarket().getName();
		  String ChannelId=ma.getChannel().getChannelType();
		  int price=ma.getOrders().get(0).getSolutionPrice();
		  String msg=String.format("%s\t%s\t%s\t%d", 
				  cid,
				  MarketId,
				  ChannelId,
				  price
				  );
		  System.out.println(msg);
	  }
  }
  
  //Q4-1：
  public static void Q4_Channel(List<MarketChannelAssignment> marketChannelAssignmentList) {
	  System.out.println("************************Q4_Channel********************\nChannel\tsales");
	  Counter.clear();
	  for(MarketChannelAssignment ma:marketChannelAssignmentList) {
		  String ChannelId=ma.getChannel().getChannelType();
		  int sales=ma.getOrders().get(0).getSolutionMoney();
		  Counter counter=new Counter(ChannelId,sales);
		  //add total sales
		  Counter.add(counter);
	  }

	  ArrayList<Counter> counterList =Counter.getCounterList();
	  for(Counter item:counterList) {
		  String msg=String.format("%s\t%d", 
				  item.getItem(),
				  item.getSales()
				  );
		  System.out.println(msg);		  
	  }
  }
  
  
  //Q4-2：
  public static void Q4_Market(List<MarketChannelAssignment> marketChannelAssignmentList) {
	  System.out.println("************************Q4_Market********************\nMarket\tsales");
	  Counter.clear();
	  for(MarketChannelAssignment ma:marketChannelAssignmentList) {
		  String mark=ma.getMarket().getName();
		  int sales=ma.getOrders().get(0).getSolutionMoney();
		  Counter counter=new Counter(mark,sales);
		  Counter.add(counter);
	  }

	  ArrayList<Counter> counterList =Counter.getCounterList();
	  for(Counter item:counterList) {
		  String msg=String.format("%s\t%d", 
				  item.getItem(),
				  item.getSales()
				  );
		  System.out.println(msg);		  
	  }
  }  
  
  
  //Q4-3：
  public static void Q4_Cust(List<MarketChannelAssignment> marketChannelAssignmentList) {
	  System.out.println("************************Q4_Customer********************\nCust\tsales");
	  Counter.clear();
	  for(MarketChannelAssignment ma:marketChannelAssignmentList) {
		  String cust=ma.getOrders().get(0).getCustomerProfile().getCustomerId();
		  int sales=ma.getOrders().get(0).getSolutionMoney();
		  Counter counter=new Counter(cust,sales);
		  Counter.add(counter);
	  }
	  
	  ArrayList<Counter> counterList =Counter.getCounterList();
	  for(Counter item:counterList) {
		  String msg=String.format("%s\t%d", 
				  item.getItem(),
				  item.getSales()
				  );
		  System.out.println(msg);		  
	  }
  }  
  
  //Q5
  public static void Q5_Market_sex(List<MarketChannelAssignment> marketChannelAssignmentList) {
	  System.out.println("************************Q5_Market_Sex********************\nMarket\tMaleSales\tFemaleSales");
	  MarkSex.clear();
	  for(MarketChannelAssignment ma:marketChannelAssignmentList) {
		  String mark=ma.getMarket().getName();
		  String sex=ma.getOrders().get(0).getCustomerProfile().getPerson().getSex();
		  int sales=ma.getOrders().get(0).getSolutionMoney();
		  MarkSex markSex=null;

		  if(sex.equals("Male")) {
			  markSex=new MarkSex(mark,0,sales);
		  }else { 
			  markSex=new MarkSex(mark,sales,0);
		  }
		  //add total sales
		  MarkSex.add(markSex);
	  }
	 
	  ArrayList<MarkSex> markSexList =MarkSex.getMarkSexList();
	  for(MarkSex item:markSexList) {
		  String msg=String.format("%s\t%d\t\t%d", 
				  item.getMark(),
				  item.getMan(),
				  item.getWoman()
				  );
		  System.out.println(msg);		  
	  }
  }  
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    //Business business = ConfigureABusiness.initialize();

	  List<MarketChannelAssignment> marketChannelAssignmentList=generateMarketChannelAssignment();
	  Q1(marketChannelAssignmentList);
	  Q2(marketChannelAssignmentList);
	  Q4_Channel(marketChannelAssignmentList);
	  Q4_Market(marketChannelAssignmentList);  
	  Q4_Cust(marketChannelAssignmentList); 
	  Q5_Market_sex(marketChannelAssignmentList);
  }
}
