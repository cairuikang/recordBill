package com.jhlc.record.controller.resp;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result<T> {
    int code;
    String msg;
    T data;
}
