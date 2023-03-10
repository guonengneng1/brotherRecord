package org.example.brotherRecord.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrotherRecordResponse {
    Integer code;
    String msg;
    Object data;
}
