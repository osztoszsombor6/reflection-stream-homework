package reflect;

import java.lang.reflect.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;

public class Homework1 {

    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public void streamPipeline1() {
        Arrays.stream(String.class.getDeclaredMethods())
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     *  Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline2() {
        Arrays.stream(String.class.getDeclaredMethods())
                .map(m -> m.getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public void streamPipeline3() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(method -> method.getParameterCount() > 1)
                .filter(method -> Arrays.stream(method.getParameterTypes()).distinct().count() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline4() {
        Arrays.stream(String.class.getDeclaredMethods())
                .map(method -> method.getReturnType().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public void streamPipeline5() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(method -> Arrays.stream(method.getParameterTypes()).anyMatch(aClass -> aClass.equals(boolean.class)))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String whose parameters are all of type int, sorted by name.
     */
    public void streamPipeline6() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(method -> method.getParameterCount() > 0)
                .filter(method -> Arrays.stream(method.getParameterTypes()).allMatch(aClass -> aClass.equals(int.class)))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public String streamPipeline7() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .map(method -> method.getName())
                .max(Comparator.comparing(String::length))
                .get();
    }

    /**
     *  Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public String streamPipeline8() {
        return Arrays.stream(String.class.getMethods())
                .map(method -> method.getName())
                .max(Comparator.comparing(String::length))
                .get();
    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public IntSummaryStatistics streamPipeline9() {
        return Arrays.stream(String.class.getMethods())
                .mapToInt(method-> method.getParameterCount())
                .summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public int streamPipeline10() {
        return Arrays.stream(String.class.getMethods())
                .mapToInt(method-> method.getParameterCount())
                .max()
                .getAsInt();
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public Method streamPipeline11() {
        return Arrays.stream(String.class.getMethods())
                .max(Comparator.comparingInt(Method::getParameterCount))
                .get();
    }

    /**
     * Prints all distinct parameter types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline12() {
        Arrays.stream(String.class.getMethods())
                .flatMap(method -> Arrays.stream(method.getParameterTypes()))
                .map(aClass -> aClass.getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }

}
