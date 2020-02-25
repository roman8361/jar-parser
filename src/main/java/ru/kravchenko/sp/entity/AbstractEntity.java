package ru.kravchenko.sp.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
abstract class AbstractEntity {

    private String id = UUID.randomUUID().toString();

}
