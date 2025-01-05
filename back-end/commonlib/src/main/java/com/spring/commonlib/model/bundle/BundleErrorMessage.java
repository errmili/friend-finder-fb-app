package com.spring.commonlib.model.bundle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Setter
@Getter
@AllArgsConstructor
public class BundleErrorMessage {
    @JsonProperty("arabic_message")
    private String arabicMessage;
    @JsonProperty("english_message")
    private String englishMessage;
}