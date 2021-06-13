package com.cleevio.warehouse.web.model;

import com.cleevio.warehouse.repository.model.Watch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WatchDTO {

    @NotNull
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private Integer price;

    private String description;
    @NotNull
    private byte[] fountain;

    public WatchDTO(Watch watch) {
        this.id = watch.getId();
        this.title = watch.getTitle();
        this.price = watch.getPrice();
        this.description = watch.getDescription();
        this.fountain = watch.getFountain();
    }
}
