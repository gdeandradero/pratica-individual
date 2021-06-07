package com.meli.springchallenge.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Comparator;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post implements Comparable<Post> {
    private Long userId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Product detail;
    private Long category;
    private Double price;
    private boolean hasPromo;
    private Double discount;

    @Override
    public int compareTo(Post o) {
        /*
         * this date before date argument
         */
        if (this.date.compareTo(o.date) < 0){
            return 1;
        }
        /*
         * this date after date argument
         */
        else if (this.date.compareTo(o.date) > 0){
            return -1;
        }
        /*
         * dates are equals
         */
        return 0;
    }
}
