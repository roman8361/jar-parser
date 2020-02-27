package ru.kravchenko.sp.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class Company extends AbstractEntity {

    private String name;

    private String description;

    private String telephone;

    private String url;

    private String hidingId; // поле необходимо для get запроса, чтобы получить телефон компании

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", telephone='" + telephone + '\'' +
                ", hidingId='" + hidingId + '\'' +
 //               ", id='" + this.getId() + '\'' + //если нужны будут id сущность разкомментить
                '}';
    }

}
