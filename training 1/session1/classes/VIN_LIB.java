import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VIN_LIB {

    // Регулярное выражение парсит VIN и режет на отдельные куски.
// wmi - World Manufacturers Identification
// vds - Vehicle Description Section
// sign - Control sign
// modelYear - Vehicle model year
// vis - Vehicle Identification Section
    public static final String regex = "^(?<wmi>[a-hj-npr-zA-HJ-NPR-Z1-9]{3})(?<vds>[a-hj-npr-zA-HJ-NPR-Z0-9]{5})(?<sign>[a-hj-npr-zA-HJ-NPR-Z0-9]{1})(?<modelYear>[a-hj-npr-yA-HJ-NPR-Y1-9]{1})(?<vis>[a-hj-npr-zA-HJ-NPR-Z0-9]{3}[0-9]{4})$";

    // Массив содержит в себе модельные годы автомобилей, начиная с 1980-го
// A: 1980; B: 1981, etc.
    private static Map<Character, Integer> yearsModel = new HashMap<Character, Integer>();

    // Массив содержит в себе информацию о странах по их кодам.
// AA: ЮАР; 1A: США, etc.
    private static Map<String, String> countries = new HashMap<String, String>();

    private static String countryCodes =
            "AA-AH ЮАР;AJ-AN Котд'Ивуар;BA-BE Ангола;BF-BK Кения;BL-BR Танзания;CA-CE Бенин;CF-CK Мадагаскар;CL-CR Тунис;DA-DE " +
                    "Египет;DF-DK Марокко;DL-DR Замбия;EA-EE Эфиопия;EF-EK Мозамбик;FA-FE Гана;FF-FK Нигерия;JA-JT Япония;KA-KE " +
                    "ШриЛанка;KF-KK Израиль;KL-KR Южная Корея;KS-K0 Казахстан;LA-L0 Китай;MA-ME Индия;MF-MK Индонезия;ML-MR " +
                    "Таиланд;NF-NK Пакистан;NL-NR Турция;PA-PE Филиппины;PF-PK Сингапур;PL-PR Малайзия;RA-RE ОАЭ;RF-RK Тайвань;RL-RR " +
                    "Вьетнам;RS-R0 Саудовска я Аравия;SA-SM Великобритания;SN-ST Германия;SU-SZ Польша;S1-S4 Латвия;TA-TH " +
                    "Швейцария;TJ-TP Чехия;TR-TV Венгрия;TW-T1 Португалия;UH-UM Дания;UN-UT Ирландия;UU-UZ Румыния;U5-U7 " +
                    "Словакия;VA-VE Австрия;VF-VR Франция;VS-VW Испания;VX-V2 Сербия;V3-V5 Хорватия;V0-V6 Эстония;WA-W0 " +
                    "Германия;XA-XE Болгария;XF-XK Греция;XL-XR Нидерланды;XS-XW СССР/СНГ;XX-X2 Люксембург;X0-X3 Россия;YA-YE " +
                    "Бельгия;YF-YK Финляндия;YL-YR Мальта;YS-YW Швеция;YX-Y2 Норвегия;Y3-Y5 Беларусь;Y0-Y6 Украина;ZA-ZR Италия;" +
                    "1A-10 США;2A-20 Канада;3A-3W Мексика;3X-37 Коста Рика;30-38 Каймановы острова;4A-40 США;5A-50 США;6A-6W " +
                    "Австралия;7A-7E Новая Зеландия;8A-8E Аргентина;8F-8K Чили;8L-8R Эквадор;8S-8W Перу;8X-82 Венесуэла;9A-9E " +
                    "Бразилия;9F-9K Колумбия;9L-9R Парагвай;9S-9W Уругвай;9X-92 Тринидад и Тобаго;93-99 Бразилия;ZX-Z2 " +
                    "Словения;Z3-Z5 Литва;Z0-Z6 Россия";


    public static void main(String[] args) {

    }

    public static boolean checkVin(String vin) {
        if (vin.length() == 17) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(vin);
            return !matcher.equals(null);
        }
        return false;
    }

    public static String getVinCountry(String vin) {
        fillCountries();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(vin.toUpperCase(Locale.ROOT));
        String countryCode = "";
        while (matcher.find()) {
            countryCode = String.valueOf(matcher.group("wmi"));
        }
        String getCode = countryCode.substring(0, 2); //получает два первых символа из WMI для поиска страны в массиве стран
        return countries.get(getCode);
    }

    public static int getTransportYear(String vin) {
        fillYears();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(vin.toUpperCase());

        String val = vin.replaceAll("^[a-hj-npr-zA-HJ-NPR-Z1-9]{13}", "");
        int vals = Integer.parseInt(val);
        Character year = 0;
        if (vals <= 153757) {
            if (matcher.find()) {
                year = matcher.group("modelYear").charAt(0);
                if (yearsModel.get(year) + 30 <= 2022) {
                    return yearsModel.get(year) + 30;
                }
            }
        }
        return yearsModel.get(year);
    }

    private static void fillCountries() {
        String[] codes = countryCodes.split(";");
        for (String code : codes
        ) {
            char[] sep = {' '};
            String[] codeInfo = code.split(String.valueOf(sep), 2);
            for (int i = 0; i < codeInfo.length; i++) {

                String ziro = String.valueOf(codeInfo[i].charAt(0));//первый символ из диапазона, напр. В из ВА-СР
                String.valueOf(codeInfo[i].charAt(0));
                char one = codeInfo[i].charAt(1);//второй символ из диапазона, напр. А из ВА-СР
                char two = codeInfo[i].charAt(4);//пятый символ из диапазона, напр. Р из ВА-СР
                while (two >= one) {//заполняет массив стран пока пятый символ больше второго
                    countries.put(ziro + one, codeInfo[i + 1]);
                    one++;
                }
                i++;
            }
        }
    }

    private static void fillYears() {
        int year = 1980;
        for (int i = 65; i <= 89; ++i)  { // A..y
            if (i == 81 || i == 79 || i == 73 || i == 85)
                continue;
            yearsModel.put((char) i, year);
            ++year;
        }
        for (int i = 49; i <= 57; ++i)  { // 0..9
            yearsModel.put((char) i, year);
            ++year;
        }
    }
}
