/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebookstore.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Suha
 */
@Entity
@Table(name = "profit")
@NamedQueries({
    @NamedQuery(name = "Profit.findAll", query = "SELECT p FROM Profit p"),
    @NamedQuery(name = "Profit.findById", query = "SELECT p FROM Profit p WHERE p.id = :id"),
    @NamedQuery(name = "Profit.findByMonth", query = "SELECT p FROM Profit p WHERE p.month = :month"),
    @NamedQuery(name = "Profit.findByNetprofit", query = "SELECT p FROM Profit p WHERE p.netprofit = :netprofit")})
public class Profit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "month")
    private String month;
    @Basic(optional = false)
    @NotNull
    @Column(name = "netprofit")
    private int netprofit;

    public Profit() {
    }

    public Profit(Integer id) {
        this.id = id;
    }

    public Profit(Integer id, int netprofit) {
        this.id = id;
        this.netprofit = netprofit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getNetprofit() {
        return netprofit;
    }

    public void setNetprofit(int netprofit) {
        this.netprofit = netprofit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profit)) {
            return false;
        }
        Profit other = (Profit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ebookstore.model.Profit[ id=" + id + " ]";
    }
    
}
