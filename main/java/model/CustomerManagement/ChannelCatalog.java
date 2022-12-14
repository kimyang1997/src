/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;

import model.MarketModel.Channel;

/**
 *
 * @author kal bugrara
 */
public class ChannelCatalog {
    ArrayList<Channel> channelList;
    public ChannelCatalog(){
        channelList = new ArrayList();
    }

    public Channel newChannel(String type){
    	Channel c = new Channel(type);
    	channelList.add(c);
        return c;
    }

    public Channel findChannel(String type){
        for (Channel c : channelList){
            if (c.getChannelType().equalsIgnoreCase(type)) return c;
        }
        return null;
    }
    
}
