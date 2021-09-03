package com.robinfood.demo.dto;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CommandResponseDTO {

    private String message;
}
