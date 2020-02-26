package ru.kravchenko.sp;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sp.api.IStringUtilService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class StringUtilTest {

    @Autowired
    private IStringUtilService stringUtilService;

    @Test
    public void testUtilClass() {
        String paginatorTest = "<li class=\"ui_last_page\"><a href=\"/list/magaziny_santekhnika/page/24/\"><img src=\"/images/icn/double_arrow_right_2_b.png\" alt=\"\"></a></li>\n";
        String paginatorTest1 = "<li class=\"ui_last_page\"><a href=\"/list/magaziny_santekhnika/page/4/\"><img src=\"/images/icn/double_arrow_right_2_b.png\" alt=\"\"></a></li>\n";
        String paginatorTest2 = "<li class=\"ui_last_page\"><a href=\"/list/magaziny_santekhnika/page/111/\"><img src=\"/images/icn/double_arrow_right_2_b.png\" alt=\"\"></a></li>\n";

        Assert.assertSame(4, stringUtilService.getLastPaginatorNumber(paginatorTest1));
        Assert.assertSame(24, stringUtilService.getLastPaginatorNumber(paginatorTest));
        Assert.assertSame(111, stringUtilService.getLastPaginatorNumber(paginatorTest2));
    }

}
