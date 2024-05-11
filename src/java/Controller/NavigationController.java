/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author zafer
 */
@Named
@RequestScoped
public class NavigationController implements Serializable{
    public String page(String p){
        return "/pages/"+p+"?faces-redirct=true";
    }
}
