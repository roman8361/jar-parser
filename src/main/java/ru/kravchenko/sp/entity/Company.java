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



}
