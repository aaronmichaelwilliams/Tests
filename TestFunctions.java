public class TestFunctions {

    public static String StripWhiteSpace(String input) {
        return input.replaceAll("\\n", "").replaceAll("\\s", "").trim();
    }

    public static void tearDownDB() {
        Database db = new Database();
        db.connect("amwilliams");
        db.insert("delete from vl_customers;");
        db.insert("delete from vl_reviews;");
        db.disconnect();
    }
}
