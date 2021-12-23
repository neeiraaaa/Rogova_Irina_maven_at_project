package demo.classwork20;

import java.io.IOException;

public class RunnerRecipe {
    public static void main(String[] args) throws IOException {
        SimpleJsonParser simpleJsonParser = new SimpleJsonParser();
        simpleJsonParser.parseJSON();
        simpleJsonParser.parseGSON();
        simpleJsonParser.toGSON();
    }
}
