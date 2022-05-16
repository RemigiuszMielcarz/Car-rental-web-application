package pl.mielcarzswiatek.pricelist;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "price_list")
@Entity(name = "PriceList")
public class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day")
    private Integer day;

    @Column(name = "weekend")
    private Integer weekend;

    @Column(name = "week")
    private Integer week;

    @Column(name = "month")
    private Integer month;

    public PriceList(Integer day, Integer weekend, Integer week, Integer month) {
        this.day = day;
        this.weekend = weekend;
        this.week = week;
        this.month = month;
    }
}