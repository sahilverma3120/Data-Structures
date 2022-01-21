/*
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
*/



class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int reserve = 0;
        int n = gas.length;
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if (totalCost > totalGas) {
            return -1;
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            reserve += (gas[i] - cost[i]);
            if (reserve < 0) {
                reserve = 0;
                index = i + 1;
            }
        }
        return index;
    }
}
