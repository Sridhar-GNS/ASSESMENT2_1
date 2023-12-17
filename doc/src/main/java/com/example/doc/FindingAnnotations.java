package com.example.doc;
import com.example.doc.annotations.ClassDocumentation;
import com.example.doc.annotations.MethodDocumentation;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;

import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class FindingAnnotations {
    static List<String> javaDocs = new ArrayList<>();
    public static void main(String[] args) {
        processAnnotatedClassesAndMethods();
    }
    public static void processAnnotatedClassesAndMethods() {
        try (Stream<Path> paths = Files.walk(Paths.get("C:\\Gradle\\doc\\doc\\src\\main\\java\\com\\example\\doc\\models"))) {
            paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .forEach(FindingAnnotations::analyzeFile);
        } catch (IOException e) {
            System.out.println("Error reading files");
        }
    }
    private static void analyzeFile(Path path) {
        Path outputPath = Paths.get("javadoc.txt");
        try {
            CompilationUnit cu = JavaParser.parse(path.toFile());
            for (TypeDeclaration type : cu.getTypes()) {
                processType(type);
            }
            try {
                Files.write(outputPath, javaDocs, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                System.out.println("Error writing to output file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + path);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    private static void processType(TypeDeclaration type) {
        if (type.getAnnotations().stream().anyMatch(a -> a.getName().getName().equals(ClassDocumentation.class.getSimpleName()))) {
            System.out.println("Class " + type.getName() + " is annotated with @ClassDocumentation");
        } else {
            System.out.println("Class " + type.getName() + " is not annotated with @ClassDocumentation");
        }
        Comment commentOpt = type.getComment();
        processComment(type.getName(), commentOpt);
        for (BodyDeclaration member : type.getMembers()) {
            if (member instanceof MethodDeclaration) {
                processMethod((MethodDeclaration) member, type.getName());
            }
        }
        System.out.println();
    }
    private static void processMethod(MethodDeclaration method, String className) {
        if (method.getAnnotations().stream().anyMatch(a -> a.getName().getName().equals(MethodDocumentation.class.getSimpleName()))) {
            System.out.println("Method " + method.getName() + " in class " + className + " is annotated with @MethodDocumentation");
        } else {
            System.out.println("Method " + method.getName() + " in class " + className + " is not annotated with @MethodDocumentation");
        }
        Comment commentOpt = method.getComment();
        processComment(method.getName(), commentOpt);
    }
    private static void processComment(String name, Comment commentOpt) {
        if (commentOpt instanceof JavadocComment) {
            JavadocComment comment = (JavadocComment) commentOpt;
            String javadoc = "Element " + name + " has JavaDoc comment: \n" + comment.toString() + "\n";
            javaDocs.add(javadoc);
        } else {
            System.out.println("Element " + name + " has no JavaDoc comment");
        }
    }
}