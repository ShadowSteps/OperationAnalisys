/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.operationanalisys.main.menu;

/**
 *
 * @author John
 */
public enum MenuFunctionTypes {
    GradientDescent(1),
    Projection(2),
    MinMax(3),
    Stochastic(4);
    
    private final int value;

    private MenuFunctionTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
