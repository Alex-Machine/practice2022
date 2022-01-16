import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REG_MARK_LIB {

    private static String seriesChars = "ABCEHKMOPTYX";
    public static final String regex = "^(?<before>[aAbBeEkKmMhHoOpPcCtTyYxX])(?<number>[0-9]{3})(?<after>[aAbBeEkKmMhHoOpPcCtTyYxX]{2})(?<region>[0-9]{2,3})$";


    public static void main(String[] args) {

    }

    public static boolean checkMark(String mark) {
        if (mark.length() == 7 || mark.length() == 8) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(mark);
            return !matcher.equals(null);
        }
        return false;
    }

    public static String getNextMarkAfter(String mark) {
        if (checkMark(mark)) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(mark);
            String series = "";
            String result = "";
            while (matcher.find()) {
                series = matcher.group("before") + matcher.group("after");
                int number = Integer.parseInt(matcher.group("number"));

                //если число меньше 999, просто увеличиваем его
                if (number < 999) {
                    number++;
                    return result = matcher.group("before") + number + matcher.group("after") + matcher.group("region");
                }
                // В противном случае возвращаем число к 000 и разбираем символы, если это возможно.
                else {
                    int[] indexes = {seriesChars.indexOf(series.charAt(0)), seriesChars.indexOf(series.charAt(1)), seriesChars.indexOf(series.charAt(2))};
                    if (indexes[0] < seriesChars.length() && indexes[2] != 11) {
                        return result = series.charAt(0) + "000" + series.charAt(1) + seriesChars.charAt(indexes[2] + 1) + matcher.group("region");
                    } else if (indexes[1] < seriesChars.length()) {
                        return result = series.charAt(0) + "000" + seriesChars.charAt(indexes[1] + 1) + seriesChars.charAt(0) + matcher.group("region");
                    } else if (indexes[2] < seriesChars.length()) {
                        return result = seriesChars.charAt(indexes[0] + 1) + "000" + seriesChars.charAt(0) + seriesChars.charAt(0) + matcher.group("region");
                    } else {
                        return result = seriesChars.charAt(0) + "000" + seriesChars.charAt(0) + seriesChars.charAt(0) + matcher.group("region");
                    }
                }
            }
        }
        return "";
    }

    /// Получает следующий регистрационный номер
    ///     A999AA124 -> A000AB124
    public static String getNextMarkAfterInRange(String prevMark, String rangeStart, String rangeEnd) {
        if (getCombinationsCountInRange(prevMark, rangeEnd) <= 0)
            return "out of stock";
        else if (getCombinationsCountInRange(rangeStart, rangeEnd) <= 0)
            return "out of stock";
        return getNextMarkAfter(prevMark);
    }

    public static int markToInt(Matcher matched) {
        while (matched.find()) {
            int result = Integer.parseInt(matched.group("number"));
            result += seriesChars.indexOf(matched.group("after"), 1) * 1000;
            result += seriesChars.indexOf(matched.group("after"), 0) * 1000 * seriesChars.length();
            result += seriesChars.indexOf(matched.group("before"), 0) * 1000 * seriesChars.length() * seriesChars.length();
            return result;
        }
        return 0;
    }

    private static Integer getCombinationsCountInRange(String mark1, String mark2) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(mark1);
        Matcher matcher2 = pattern.matcher(mark2);
        return markToInt(matcher2) - markToInt(matcher1);
    }
}


