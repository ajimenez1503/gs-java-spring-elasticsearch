package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Field;

import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Author {

    @Field(type = Text)
    private String name;
}
