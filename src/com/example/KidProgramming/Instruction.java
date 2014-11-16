package com.example.KidProgramming;

/**
 * Created by thanh on 11/14/14.
 */
public class Instruction {
    int imageId;
    String nameInstruction;

    public Instruction() {
    }

    public Instruction(int imageId, String nameInstruction) {
        this.imageId = imageId;
        this.nameInstruction = nameInstruction;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getNameInstruction() {
        return nameInstruction;
    }

    public void setNameInstruction(String nameInstruction) {
        this.nameInstruction = nameInstruction;
    }
}
