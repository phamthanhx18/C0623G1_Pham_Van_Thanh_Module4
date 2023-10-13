package com.example.caculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    public int calculator(int numberA, int numberB, String type) {
        int result = 0;
        switch (type) {
            case "addition":
                result = numberA + numberB;
                break;
            case "subtraction":
                result = numberA - numberB;
                break;
            case "multiplication":
                result = numberA * numberB;
                break;
            case "division":
                result = numberA / numberB;
                break;
        }
        return result;
    }
}
