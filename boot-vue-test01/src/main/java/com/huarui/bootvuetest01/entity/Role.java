package com.huarui.bootvuetest01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private int rid;
    private String rname;
    private String rdesc;
}
