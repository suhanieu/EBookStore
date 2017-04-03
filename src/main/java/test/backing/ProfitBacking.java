/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.backing;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import test.service.ProfitService;

/**
 *
 * @author Suha
 */
@Named(value = "profitBacking")
@ViewScoped

public class ProfitBacking {

    @EJB
    ProfitService profitService;

    public void callingToProfit() {

        profitService.getAllMonth();

    }
    

}
