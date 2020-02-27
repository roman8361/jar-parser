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

    public void insert(Company company) {
        if (company == null) return;
        companyList.add(company);
    }

    public Company findById(String id) {
        if (id == null || id.isEmpty()) return null;
        return companyList.stream().filter(x -> x.getId().equals(id)).findAny().orElse(null);
    }

    public Company findByContactId(String contactId) {
        if (contactId == null || contactId.isEmpty()) return null;
        return companyList.stream().filter(x -> x.getHidingId().equals(contactId)).findAny().orElse(null);
    }

    public void delById(String id) {
        if (id == null || id.isEmpty()) return;
        Company company = companyList.stream().filter(x -> x.getId().equals(id)).findAny().orElse(null);
        companyList.remove(company);
    }

    public List<Company> getAll() { return companyList; }

    public void showAll() {
        companyList.forEach(System.out::println);
    }

    public void insertAll(List<Company> companies) {
        companyList.addAll(companies);
    }

}
