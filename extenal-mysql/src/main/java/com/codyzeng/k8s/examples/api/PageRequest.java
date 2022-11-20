package com.codyzeng.k8s.examples.api;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO〈一句话功能简述〉<br>
 *
 */
@Getter
@Setter
public class PageRequest<T> implements Serializable {

    private int current = 1;
    private int size = 10;
    private T param;
}
