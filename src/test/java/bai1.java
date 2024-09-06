import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        /*   *//*System.out.printf("Hello World\n");
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập vào chuỗi ký tự: ");
        String str = sc.nextLine();
        System.out.println(str);
        System.out.println(str.toUpperCase());
        System.out.println(str.length());
        String kytu = String.valueOf(str.charAt(4));
        System.out.println(kytu);
        System.out.println("abc".equals("ABC")); // false
        System.out.println("ABC".equals("ABC")); // true
        System.out.println("123".equals("123")); // true
        System.out.println("abc".equalsIgnoreCase("ABC")); // true*//*
        //charAt
        var name4 = "animals";
        System.out.println(name4.charAt(0)); // a
        System.out.println(name4.charAt(6)); // s
        System.out.println(name4.charAt(7)); // exception
        //.indexOf()
        var name = "animals";
        System.out.println(name.indexOf('a')); // 0
        System.out.println(name.indexOf("al")); // 4
        System.out.println(name.indexOf('a', 4)); // 4
        System.out.println(name.indexOf("al", 5)); // -1
        // .substring()
        var name1 = "animals";
        System.out.println(name1.substring(3)); // mals
        System.out.println(name1.substring(name.indexOf('m'))); // mals
        System.out.println(name1.substring(3, 4)); // m
        System.out.println(name1.substring(3, 7)); // mals
        System.out.println(name1.substring(3, 3)); // empty string
        System.out.println(name1.substring(3, 2)); // exception
        System.out.println(name1.substring(3, 8)); // exception
        //toUpperCase và toLowerCase
        var name2 = "animals";
        System.out.println(name2.toUpperCase()); // ANIMALS
        System.out.println("Abc123".toLowerCase()); // abc123
        // equals
        System.out.println("abc".equals("ABC")); // false
        System.out.println("ABC".equals("ABC")); // true
        System.out.println("abc".equalsIgnoreCase("ABC")); // true
        // strarWith, endWith và contains
        System.out.println("abc".startsWith("a")); // true
        System.out.println("abc".startsWith("A")); // false
        System.out.println("abc".endsWith("c")); // true
        System.out.println("abc".endsWith("a")); // false
        System.out.println("abc".contains("b")); // true
        System.out.println("abc".contains("B")); // false
        // replace()
        System.out.println("abcabc".replace('a', 'A')); // AbcAbc
        System.out.println("abcabc".replace("a", "A")); // AbcAbc
        // indent() và stripIndent()
        var block = """
                a
                 b
                c""";
        var concat = " a\n"
        + "  b\n"
        + " c";
        System.out.println(block.length()); // 6
        System.out.println(concat.length()); // 9
        System.out.println(block.indent(1).length()); // 10
        System.out.println("====================");
        System.out.println(block.indent(1)); // 10
        System.out.println("====================");
        System.out.println(concat.indent(-1).length()); // 7
        System.out.println("====================");
        System.out.println(concat.indent(-1)); // 7
        System.out.println("====================");
        System.out.println(concat.indent(-4).length()); // 6
        System.out.println(concat.stripIndent().length()); // 6*/
        var name = "Kate";
        var name2 = "Dang";
        var orderId = 5;
        String result = String.format("Hello %s, order %d is ready", name, orderId);
        String result2 = String.format("Hello %s, Iam %s order %d is ready", name, name2, orderId);
        System.out.println(result);
        System.out.println(result2);
        var name3 = "James";
        var score = 90.25;
        var total = 100;
        System.out.println("%s:%nScore: %f out of %d".formatted(name3, score, total));
        // khởi tọa lis5
        ArrayList<String> lst = new ArrayList<>();
        // khởi tọa với số lượng pt ban đầu
        ArrayList<String> lst2 = new ArrayList<>(5);
        // Khởi tạo list với các phần tử ban đầu
        ArrayList<Integer> lst3 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 6, 5, 3, 4));

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());
        var time1 = LocalTime.of(6, 15); // giờ và phút
        var time2 = LocalTime.of(6, 15, 30); // + giây
        var time3 = LocalTime.of(6, 15, 30, 200); // + nano giây
        var date1 = LocalDate.of(2022, Month.JANUARY, 20);
        var date2 = LocalDate.of(2022, 1, 20);
        var dateTime1 = LocalDateTime.of(2022, Month.JANUARY, 20, 6, 15, 30);
        var dateTime2 = LocalDateTime.of(date1, time1);
        System.out.println("==============");
        System.out.println(String.valueOf(time1));
        System.out.println(String.valueOf(time2));
        System.out.println(String.valueOf(time3));
        System.out.println(String.valueOf(date1));
        System.out.println(String.valueOf(date2));
        System.out.println(String.valueOf(dateTime1));
        System.out.println(String.valueOf(dateTime2));
        var d = LocalDate.of(2022, Month.JANUARY, 31); // DateTimeException
        System.out.println(String.valueOf(d));



        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
        System.out.println(cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+ cal.get(Calendar.YEAR));



            var start = LocalDate.of(2022, Month.JANUARY, 1);
            var end = LocalDate.of(2022, Month.MARCH, 30);
            var period = Period.ofMonths(1); // tạo một khoảng thời gian
            performAnimalEnrichment(start, end, period);
        }

        private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) { // sử dụng khoảng thời gian tổng quát
            var upTo = start;
            while (upTo.isBefore(end)) {
                System.out.println("cho đồ chơi mới: " + upTo);
                upTo = upTo.plus(period); // thêm khoảng thời gian
            }

            var wrong = Period.ofYears(1);
            wrong = Period.ofWeeks(1);
            System.out.printf(String.valueOf(wrong));
    }
}
