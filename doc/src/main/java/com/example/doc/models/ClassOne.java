package com.example.doc.models;

import com.example.doc.annotations.ClassDocumentation;
import com.example.doc.annotations.MethodDocumentation;

/**
 * This is a class ClassOne.
 *
 * @ClassDocumentation "This is a class ClassOne"
 */
@ClassDocumentation("This is a class ClassOne")
public class ClassOne {

    /**
     * This is a method MethodOne inside ClassOne.
     *
     * @MethodDocumentation "This is a method MethodOne inside ClassOne"
     */
    @MethodDocumentation("This is a method MethodOne inside ClassOne")
    public void MethodOne() {
        System.out.println("MethodOne");
    }

    /**
     * This is a method MethodTwo inside ClassOne.
     *
     * @MethodDocumentation "This is a method MethodTwo inside ClassOne"
     */
    @MethodDocumentation("This is a method MethodTwo inside ClassOne")
    public void MethodTwo() {
        System.out.println("MethodTwo");
    }

    @MethodDocumentation("This is a method MethodThree inside ClassOne")
    public void MethodThree() {
        System.out.println("MethodThree");
    }

    /**
     * This is a method MethodFour inside ClassOne.
     *
     * @MethodDocumentation "This is a method MethodFour inside ClassOne"
     */
    public void MethodFour() {
        System.out.println("MethodFour");
    }
}