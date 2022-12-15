package com.example.demo.model;
/**
 * This class is the use the setter and getter methods for better reusability
 * @author Hemanth Avinash - Not Implemented
 *
 */
public class GameModel {
    private String name;
    private float value;


    // Getter Methods

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(float value) {
        this.value = value;
    }
}