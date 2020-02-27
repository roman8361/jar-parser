package ru.kravchenko.sp.util;

    /**
    Утилитный класс. Получение значение пагинатора.
    Используется не лучшее решение, ввиде хардкора, когда-нибудь надо переделать в нормальный вид
    можно пробовать поискать регулярные выражения или что-то такое.
    Пример строки:
    <li class=\"ui_last_page\"><a href=\"/list/magaziny_santekhnika/page/24/\"><img src=\"/images/icn/double_arrow_right_2_b.png\" alt=\"\"></a></li>\n"
    необходимо взять цифру 24 после "page/"
    */
public final class StringUtil {

    public static Integer getLastPaginatorNumber(String text) {
        String rowPageNumber = text.substring(text.indexOf("page/"), text.indexOf("page/") + 9);
        int firstIndex = rowPageNumber.indexOf("/") + 1;
        int lastIndex = rowPageNumber.lastIndexOf("/");
        String numberPaginator = rowPageNumber.substring(firstIndex, lastIndex);

        return Integer.parseInt(numberPaginator); // TODO получение значение пагинатора хардкод, когда-нибудь переделать
    }

}
