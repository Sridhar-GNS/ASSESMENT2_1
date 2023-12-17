package com.example.doc.models;


import com.example.doc.annotations.ClassDocumentation;
import com.example.doc.annotations.MethodDocumentation;

/**
 * This is a class ClassThree.
 *
 * @ClassDocumentation "This is a class ClassThree"
 */
@ClassDocumentation("This is a class ClassThree")
public class ClassThree {

    /**
     * This is a method Alpha inside ClassThree.
     *
     * @MethodDocumentation "This is a method Alpha inside ClassThree"
     */
    @MethodDocumentation("This is a method Alpha inside ClassThree")
    public void Alpha() {
        System.out.println("Alpha");
    }

    /**
     * This is a method Beta inside ClassThree.
     *
     * @MethodDocumentation "This is a method Beta inside ClassThree"
     */
    @MethodDocumentation("This is a method Beta inside ClassThree")
    public void Beta() {
        System.out.println("Beta");
    }

    /**
     * This is a method Gamma inside ClassThree.
     *
     * @MethodDocumentation "This is a method Gamma inside ClassThree"
     */
    @MethodDocumentation("This is a method Gamma inside ClassThree")
    public void Gamma() {
        System.out.println("Gamma");
    }

    /**
     * This is a method Delta inside ClassThree.
     *
     * @MethodDocumentation "This is a method Delta inside ClassThree"
     */
    @MethodDocumentation("This is a method Delta inside ClassThree")
    public void Delta() {
        System.out.println("Delta");
    }
}