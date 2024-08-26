package com.connor.runnerz.run;



public class RunNotFoundException  extends RuntimeException{
    public RunNotFoundException() {
        super("Run not Found");
    }
}
