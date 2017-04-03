/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebookstore.exception;

/**
 *
 * @author Narada
 */
public class CategoryAlreadyExist extends Exception{
    private String message;

    public CategoryAlreadyExist() {
        this.message = "Category Already exists";
    }

    public CategoryAlreadyExist(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
