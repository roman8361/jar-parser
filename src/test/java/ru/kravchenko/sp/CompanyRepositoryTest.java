package ru.kravchenko.sp;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sp.entity.Company;
import ru.kravchenko.sp.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class CompanyRepositoryTest {

    private Lorem lorem = LoremIpsum.getInstance();

    private List<Company> companyList = new ArrayList<>();

    @Autowired
    CompanyRepository companyRepository;

    @Before
    public void setUp() {
        companyRepository.insertAll(getManyCompany());
    }

    @Test
    public void testInsertAndFindCompany() {
        Company company = new Company();
        companyRepository.insert(company);
        Assert.assertSame(company, companyRepository.findById(company.getId()));
    }

    @Test
    public void testDelById() {
        Company company = new Company();
        companyRepository.insert(company);
        companyRepository.delById(company.getId());
        Assert.assertNull(companyRepository.findById(company.getId()));
    }

    @Test
    @Ignore
    public void testShowAll() {
        companyRepository.showAll();
    }

    @Test // Test for learn stream
    @Ignore
    public void testFindByIdCompany() {
        companyList = getManyCompany();
        Company company = new Company();
        company.setName("Trololosha");
        String id = company.getId();
        companyList.add(company);
        companyList.forEach(System.out::println);
        System.out.println("############");

        Company company1 = companyList.stream().filter(x -> x.getId().equals(id)).findAny().orElse(null);
        System.out.println(company1);
    }

    @Test // Test for learn stream
    @Ignore
    public void testDelByIdCompany() {
        companyList = getManyCompany();
        Company company = new Company();
        company.setName("Trololosha");
        String id = company.getId();
        companyList.add(company);
        companyList.forEach(System.out::println);

        Company company1 = companyList.stream().filter(x -> x.getId().equals(id)).findAny().orElse(null);
        companyList.remove(company1);

        System.out.println("############");
        companyList.forEach(System.out::println);
    }

    private List<Company> getManyCompany() {
        List<Company> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Company company = new Company();
            company.setName(lorem.getName());
            company.setDescription(lorem.getWords(5));
            company.setHidingId(lorem.getPhone());
            company.setUrl(lorem.getUrl());
            result.add(company);
        }
        return result;
    }

}
