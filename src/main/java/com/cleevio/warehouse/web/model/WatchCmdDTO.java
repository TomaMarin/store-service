package com.cleevio.warehouse.web.model;

import com.cleevio.warehouse.repository.model.Watch;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class WatchCmdDTO {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 200)
    private String title;

    @NotNull
    @Min(0)
    private Integer price;

    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    private String fountain;

    public Watch mapToEntity() {
        return new Watch(title, price, description, Base64.decodeBase64(fountain));
    }
}
