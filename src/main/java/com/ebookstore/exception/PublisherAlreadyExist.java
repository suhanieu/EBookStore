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
public class PublisherAlreadyExist extends Exception {

    private String message;

    public PublisherAlreadyExist() {
        this.message = "Publisher Already exists";
    }

    public PublisherAlreadyExist(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
