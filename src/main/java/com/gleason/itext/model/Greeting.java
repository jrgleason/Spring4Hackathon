package com.gleason.itext.model;

/**
 * Created with IntelliJ IDEA.
 * User: jgleason
 * Date: 6/30/14
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Greeting {
    private String content;
    public Greeting(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}
