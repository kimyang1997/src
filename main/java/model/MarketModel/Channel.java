/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

/**
 *
 * @author kal bugrara
 */
public class Channel {
    String channelType; //tv, internet, mobile
    public Channel(String t){
        channelType = t;
    }
    public boolean isMatch(String t){
        if (channelType.equalsIgnoreCase(t)) return true;
        else return false;

    }
    public String getChannelType(){
        return channelType;
    }
}
