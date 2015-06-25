/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.operationanalisys.main;

import com.shadows.operationanalisys.main.menu.ConsoleMenuReader;
import com.shadows.operationanalisys.math.function.MathFunction;
import com.shadows.operationanalisys.math.function.MathFunctionWithRandomValues;
import com.shadows.operationanalisys.math.mathoptimization.MinMaxProblem;
import com.shadows.operationanalisys.math.mathoptimization.MiniminizationProblem;
import com.shadows.operationanalisys.math.mathoptimization.ProjectionProblem;
import com.shadows.operationanalisys.math.mathoptimization.StochasticProblem;
import com.shadows.operationanalisys.math.statistics.NormalDistribution;
import com.shadows.operationanalisys.math.statistics.UniformDestribution;

/**
 *
 * @author John
 */
public class ConsoleClient {
    public static void main( String[] args )
    {
        ConsoleMenuReader Reader = new ConsoleMenuReader();
        Reader.ShowMenu();
    }
}
