package com.codyzeng.k8s.examples.api;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象<br>
 *
 */
@Getter
@Setter
public class PageResponse<T> implements Serializable {

    private int current = 1;
    private int size = 10;
    private long total;
    private List<T> records;
}
