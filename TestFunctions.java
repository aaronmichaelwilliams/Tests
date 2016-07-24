public class TestFunctions {

    public static String StripWhiteSpace(String input) {
        return input.replaceAll("\\n", "").replaceAll("\\s", "").trim();
    }
}
