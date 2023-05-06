package com.epam.rd.autotasks;

public class CarouselRun {

    int[] container;
    int currentElement = 0;

    public CarouselRun(int[] container) {
        this.container = container;
    }

    public int next() {
        // When there is no more elements to decrease, returns -1
        if (isFinished())
            return -1;

        // holds the current value of the current element, then decreases the current element by one
        int currentValue = container[currentElement]--;


        boolean elementFound = false;
        // switches to the next element in insertion order. Skips zero elements
        // looks for a proper element right to the current one
        for (int i = currentElement + 1; i < container.length; i++) {
            // Skips zero elements
            if (container[i] != 0) {
                currentElement = i;
                elementFound = true;
                break;
            }
        }
        // if it couldn't find a proper element in the right of the current element,
        // then it looks for a proper element from the beginning till the current element.
        if (!elementFound) {
            for (int i = 0; i < currentElement; i++) {
                if (container[i] != 0) {
                    currentElement = i;
                    break;
                }
            }
        }

        return currentValue;
    }

    public boolean isFinished() {
        for (int element:container) {
            // if one of the elements is above 0, it is not finished
            if (element > 0)
                return false;
        }
        return true;
    }

}
