public class t1 {
    public static void main(String[] args) {
        String date = "friday";
        String month = "july";
        String day = "8";
        printAmerican(date, month, day);
        printEuropean(date, month, day);
    }

    public static void printAmerican(String date, String month, String day) {
        String outPut = date.substring(0, 1).toUpperCase() + date.substring(1);
        String format = month.substring(0, 1).toUpperCase() + month.substring(1);
        String addFormat;
        if (day.endsWith("1")) {
            addFormat = "st";
        } else if (day.endsWith("2")) {
            addFormat = "nd";
        } else if (day.endsWith("3")) {
            addFormat = "rd";
        } else {
            addFormat = "th";
        }
        System.out.println("American format: ");
        System.out.println(outPut + ", " + format + " " + day + addFormat);
    }

    public static void printEuropean(String date, String month, String day) {
        String outPut = date.substring(0, 1).toUpperCase() + date.substring(1);
        String format = month.substring(0, 1).toUpperCase() + month.substring(1);
        String addFormat;
        if (day.endsWith("1")) {
            addFormat = "st";
        } else if (day.endsWith("2")) {
            addFormat = "nd";
        } else if (day.endsWith("3")) {
            addFormat = "rd";
        } else {
            addFormat = "th";
        }
        System.out.println("European format: ");
        System.out.println(outPut + ", " + day + addFormat + " " + format);
    }
}
