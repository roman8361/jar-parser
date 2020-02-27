package ru.kravchenko.sp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sp.api.IParserService;
import ru.kravchenko.sp.api.IRequestService;
import ru.kravchenko.sp.repository.CompanyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ParserServiceTest {

    @Autowired
    IParserService parserService;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    IRequestService requestService;

    private String html;
    @Before
    public void setUp() {
        html = requestService.getAllHtmlOnePage(1);
    }

    @Test
    public void testFillUserRepository() {
        parserService.fillUserRepository(html);
        companyRepository.showAll();
        Assert.assertEquals(21, companyRepository.getAll().size());
    }

}
