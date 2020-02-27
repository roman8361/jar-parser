package ru.kravchenko.sp.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.sp.api.IParserService;
import ru.kravchenko.sp.api.IRequestService;
import ru.kravchenko.sp.entity.Company;
import ru.kravchenko.sp.repository.CompanyRepository;

@Service
public class ParserService implements IParserService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    IRequestService requestService;

    @Override
    public void fillCompanyRepository(String html) {
        Document doc = Jsoup.parse(html);
        Elements rows = doc.getElementsByClass("row");
        String contactId = null;
        for (Element element : rows) {
            try {
                Company company = new Company();
                company.setName(element.getElementsByTag("h2").get(0).text());
                contactId = element.getElementById("contactId").text().trim();
                company.setHidingId(contactId); // get contact id for telephone number
                company.setDescription(element.getElementsByClass("company__description mb0").text());
                company.setUrl(element.getElementsByAttribute("data-statclick-url").get(0).text());
                company.setTelephone(requestService.getPhoneCompany(contactId));
                companyRepository.insert(company);
            } catch (NullPointerException | IndexOutOfBoundsException e1) {
                System.out.println("contactId not found");
            }
        }
    }

    @Override
    public void fillPhoneNumberCompany() {
        for (Company company: companyRepository.getAll()) {
            company.setTelephone(requestService.getPhoneCompany(company.getHidingId()));
        }
    }

}
