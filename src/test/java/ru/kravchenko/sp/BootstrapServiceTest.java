package ru.kravchenko.sp;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sp.api.IBootstrapService;
import ru.kravchenko.sp.api.ICreateExcelFileService;
import ru.kravchenko.sp.repository.CompanyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class BootstrapServiceTest {

    @Autowired
    IBootstrapService bootstrapService;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ICreateExcelFileService createExcelFileService;

    @Test
    @SneakyThrows
    public void testInitBootstrapService() {
        bootstrapService.init();
     //   createExcelFileService.createExcelFile("plumbing.xls");
    }

}
