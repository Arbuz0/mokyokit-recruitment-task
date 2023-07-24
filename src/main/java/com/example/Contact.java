package com.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Contact {
    @JsonProperty("kontakt_id")
    private Integer contactId;

    @JsonProperty("klient_id")
    private Integer clientId;

    @JsonProperty("pracownik_id")
    private Integer employeeId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("kontakt_ts")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime contactTimestamp;
}
