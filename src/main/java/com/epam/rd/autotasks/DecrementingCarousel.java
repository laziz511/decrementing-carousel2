package com.epam.rd.autotasks;



public class DecrementingCarousel {
    boolean runIsCalled = false;

    int container[];
    public DecrementingCarousel(int capacity) {
        container = new int[capacity];
    }


    /*
     Adds an element if:
        - the element is NOT negative and zero
        - the run method is NOT called yet
        - the container is NOT full
     If element is added successfully, return true. Return false otherwise.
     */
    public boolean addElement(int element){
        if (element > 0 && !runIsCalled && !isContainerFull()) {
            addElementToContainer(element);
            return true;
        }
        return false;
    }

    public CarouselRun run(){
        if (runIsCalled)
            return null;

        runIsCalled = true;
        return new CarouselRun(container);
    }

    private boolean isContainerFull() {
        for (int element: container) {
            if (element == 0)
                return false;
        }
        return true;
    }

    private void addElementToContainer(int element) {
        for (int i = 0; i < container.length; i++) {
            if (container[i] == 0) {
                container[i] = element;
                break;
            }
        }
    }

}
