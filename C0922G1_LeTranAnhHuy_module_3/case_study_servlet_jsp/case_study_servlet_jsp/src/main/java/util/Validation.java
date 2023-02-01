package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Validation {
    public static boolean checkEmail(String email){
        String regEmail ="^[a-z]\\w+@gmail+\\.[a-z]+$";
        return email.matches(regEmail);
    }

    public static boolean checkPhoneNumber(String phone){
        String regPhone ="^090(\\d{7})|091(\\d{7})|\\(84\\)\\+90(\\d{7})|\\(84\\)\\+91(\\d{7})$";
        return phone.matches(regPhone);
    }

    public static boolean checkIdCard(String idCard){
        String regIdCard ="^\\d{9}|\\d{12}$";
        return idCard.matches(regIdCard);
    }
//
//    public static boolean checkDate(String date){
//        String redDate ="^(?:(?:31(/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
//        return date.matches(redDate);
//    }

    public static boolean checkNumberInt(Integer number) {
        return number > 0;
    }

    public static boolean checkNumberDouble(Double number) {
        return number > 0;
    }

    public static boolean checkIdGround(String idGround) {
        String regIdGround = "^[A-Z]{3}-[A-Z]{2}-$[A-Z]{2}";
        return idGround.matches(regIdGround);
    }

    public static boolean checkArea(Double areaGround) {
        return areaGround > 20;
    }

    public static boolean check(Double areaGround) {
        return areaGround > 20;
    }


    public static String formatDate(String date) {
        DateTimeFormatter formatterStart = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterEnd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatterStart).format(formatterEnd);
    }

    public static String formatDateContract(String date) {
        DateTimeFormatter formatterStart = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatterEnd = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(date, formatterStart).format(formatterEnd);
    }


}
