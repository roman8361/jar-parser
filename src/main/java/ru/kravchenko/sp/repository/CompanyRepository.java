package ru.kravchenko.sp.repository;

import org.springframework.stereotype.Repository;
import ru.kravchenko.sp.entity.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Repository
public class CompanyRepository {

    private List<Company> companyList = new ArrayList<>();

}
